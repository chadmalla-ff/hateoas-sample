package com.example.hateoassample.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class GreetingController {
    private final GreetingModelAssembler greetingModelAssembler;

    public ResponseEntity<EntityModel<GreetingModel>> getGreeting() {
        GreetingDTO greetingDTO = new GreetingDTO();
        greetingDTO.setContentTest("Hello World!");
        GreetingModelAssembler greetingModelAssembler = new GreetingModelAssembler();
        val response = greetingModelAssembler.toModelWithLinks(greetingDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/greetings")
    public ResponseEntity<PagedModel<GreetingModel>> getGreetings(PagedResourcesAssembler assembler) {
        val greetingDTO = new GreetingDTO();
        greetingDTO.setContentTest("Hello World");
        val greetingDTO2 = new GreetingDTO();
        greetingDTO2.setContentTest("Hello World");
        val greetingDTOs = new PageImpl(List.of(greetingDTO, greetingDTO2));
        val response = greetingModelAssembler.toPagedModelWithLinks((Page<GreetingDTO>) greetingDTOs, assembler);
        return new ResponseEntity(response, OK);
    }
}

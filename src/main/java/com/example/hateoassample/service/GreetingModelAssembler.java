package com.example.hateoassample.service;

import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.modelmapper.ModelMapper;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class GreetingModelAssembler extends RepresentationModelAssemblerSupport<GreetingDTO, GreetingModel> {
    private final ModelMapper modelMapper = new ModelMapper();

    public GreetingModelAssembler() {
        super(GreetingController.class, GreetingModel.class);
    }

    @Override
    public GreetingModel toModel(GreetingDTO greetingDTO) {
        return modelMapper.map(greetingDTO, GreetingModel.class);
    }

    public EntityModel<GreetingModel> toModelWithLinks(GreetingDTO greetingDTO) {

        val attributeSelfRel = linkTo(methodOn(GreetingController.class).getGreeting()).withSelfRel();

        return new EntityModel<>(toModel(greetingDTO), attributeSelfRel);
    }

    public PagedModel<GreetingModel> toPagedModelWithLinks(Page<GreetingDTO> greetings, PagedResourcesAssembler assembler) {
        val greetingModels = greetings
                .map(this::toModelWithLinks);
        return assembler.toModel(greetingModels);
    }
}

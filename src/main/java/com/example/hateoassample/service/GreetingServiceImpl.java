package com.example.hateoassample.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {
    @Override
    public Page<GreetingDTO> getGreetings(@NotNull Pageable pageable) {
        val greetingDTO = new GreetingDTO();
        greetingDTO.setContentTest("Hello World");
        val greetingDTOS = new PageImpl<>(List.of(greetingDTO));
        return greetingDTOS;
    }

    private GreetingDTO newGreetingDTO() {
        val greetingDTO = new GreetingDTO();
        greetingDTO.setContentTest("Hello World!");
        return greetingDTO;
    }
}

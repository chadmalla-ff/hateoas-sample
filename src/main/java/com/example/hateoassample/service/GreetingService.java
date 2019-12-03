package com.example.hateoassample.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GreetingService {
    Page<GreetingDTO> getGreetings(Pageable pageable);
}

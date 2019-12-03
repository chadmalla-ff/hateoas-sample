package com.example.hateoassample.configuration;

import com.example.hateoassample.service.GreetingModelAssembler;
import com.example.hateoassample.service.GreetingService;
import com.example.hateoassample.service.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfiguration {

    @Bean
    public GreetingService greetingService( ) {
        return new GreetingServiceImpl();
    }

    @Bean
    public GreetingModelAssembler getGreetingModelAssembler() {
        return new GreetingModelAssembler();
    }
}

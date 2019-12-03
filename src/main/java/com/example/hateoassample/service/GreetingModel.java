package com.example.hateoassample.service;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;



@Data
public class GreetingModel extends RepresentationModel<GreetingModel> {
    private String contentTest;

}

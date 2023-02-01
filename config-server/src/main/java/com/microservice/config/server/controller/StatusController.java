package com.microservice.config.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
public class StatusController {
    @GetMapping
    public String state(){
        return "Config Server Actually Works Fine";
    }

}

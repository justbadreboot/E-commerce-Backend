package com.microservice.api.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    public ResponseEntity<?> servicesFallBack(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("We are fighting some bugs to be better than this");
    }

}

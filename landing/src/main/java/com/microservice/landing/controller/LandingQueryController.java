package com.microservice.landing.controller;

import com.microservice.landing.service.query.LandingQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/public/landing")
@CrossOrigin(value = "*")
@Slf4j
public class LandingQueryController {

    @Autowired
    private LandingQueryService landingQueryService;


    @GetMapping
    public ResponseEntity<?> informationGet(){
        log.info("solicitud de datos al endpoint");

        return ResponseEntity.ok(landingQueryService.readInformation());
    }

}

package com.microservice.landing.controller;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.entity.Landing;
import com.microservice.landing.mapper.LandingMapper;
import com.microservice.landing.service.query.LandingQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/public/landing")
@CrossOrigin(value = "*")
@Slf4j
public class LandingQueryController {

    @Autowired
    private LandingQueryService landingQueryService;

    private LandingMapper landingMapper;

    @GetMapping
    public ResponseEntity<?> informationGet(){
        log.info("entrando al endpoint");

        return ResponseEntity.ok(landingQueryService.readInformation());
    }

}

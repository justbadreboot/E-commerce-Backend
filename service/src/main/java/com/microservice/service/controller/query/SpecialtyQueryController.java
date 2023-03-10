package com.microservice.service.controller.query;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.services.query.SpecialtyQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class SpecialtyQueryController {
    @Autowired
    private SpecialtyQueryService service;

    @GetMapping("/public/specialty")
    public ResponseEntity<?> findAllSpecialties(){
        log.info("Inside method to get all specialties");
        List<SpecialtyGetDTO> specialties = service.findAll();
        if(specialties.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialties);
    }

    @GetMapping("/public/specialty/{id}")
    public ResponseEntity<?> findSpecialtyById(@PathVariable("id") Integer id){
        log.info("Inside method to get one specialty by id");
        SpecialtyGetDTO specialtyFound = service.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialtyFound);
    }
}

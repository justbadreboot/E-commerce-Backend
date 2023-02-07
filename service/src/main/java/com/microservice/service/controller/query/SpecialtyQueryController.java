package com.microservice.service.controller.query;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.services.query.SpecialtyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/specialty")
public class SpecialtyQueryController {
    @Autowired
    private SpecialtyQueryService service;

    @GetMapping
    public ResponseEntity<?> findAllSpecialties(){
        List<SpecialtyGetDTO> specialties = service.findAll();
        if(specialties.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSpecialtyById(@PathVariable("id") Integer id){
        SpecialtyGetDTO specialtyFound = service.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialtyFound);
    }
}

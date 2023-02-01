package com.microservice.service.controller;

import com.microservice.service.entity.Specialty;
import com.microservice.service.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService service;

    @GetMapping
    public ResponseEntity<?> findAllSpecialties(){
        List<Specialty> specialties = service.findAll();
        if(specialties.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSpecialtyById(@PathVariable("id") Integer id){
        Specialty specialtyFound = service.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(specialtyFound);
    }

    @PostMapping
    public ResponseEntity<?> createSpecialty(@RequestBody Specialty specialty){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(specialty));
    }

    @PutMapping
    public ResponseEntity<?> editSpecialty(@RequestBody Specialty specialty){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(specialty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable("id") Integer id){
        Specialty specialtyFound = service.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found");
        }
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}

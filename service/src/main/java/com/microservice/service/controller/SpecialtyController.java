package com.microservice.service.controller;

import com.microservice.service.entity.Specialty;
import com.microservice.service.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyController {
    @Autowired
    private SpecialtyService service;

    @GetMapping
    public List<Specialty> findAllSpecialties(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Specialty findSpecialtyById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Specialty createSpecialty(Specialty specialty){
        return service.create(specialty);
    }

    @PutMapping
    public Specialty editSpecialty(Specialty specialty){
        return service.edit(specialty);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecialty(@PathVariable("id") Integer id){
        service.remove(id);
    }



}

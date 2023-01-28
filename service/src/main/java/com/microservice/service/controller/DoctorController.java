package com.microservice.service.controller;

import com.microservice.service.entity.Doctor;
import com.microservice.service.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping
    public List<Doctor> findAllDoctors(){
        return service.finAll();
    }

    @GetMapping("/{id}")
    public Doctor findDoctorById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Doctor createDoctor(Doctor doctor){
        return service.save(doctor);
    }

    @PutMapping
    public Doctor editDoctor(Doctor doctor){
        return service.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id){
        service.remove(id);
    }


}

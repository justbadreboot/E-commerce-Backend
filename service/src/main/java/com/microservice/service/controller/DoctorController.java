package com.microservice.service.controller;

import com.microservice.service.entity.Doctor;
import com.microservice.service.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @GetMapping
    public ResponseEntity<?> findAllDoctors(){
        List<Doctor> doctors = service.finAll();
        if(doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDoctorById(@PathVariable("id") Integer id){
        Doctor doctorFound = service.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service);
    }

    @PostMapping
    public ResponseEntity<?> createDoctor(Doctor doctor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doctor));
    }

    @PutMapping
    public ResponseEntity<?> editDoctor(Doctor doctor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id){
        Doctor doctorFound = service.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}

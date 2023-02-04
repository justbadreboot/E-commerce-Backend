package com.microservice.service.controller;

import com.microservice.service.entity.Doctor;
import com.microservice.service.entity.Specialty;
import com.microservice.service.services.DoctorService;
import com.microservice.service.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorService service;

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/doctor")
    public ResponseEntity<?> getAllDoctors(){
        List<Doctor> doctors = service.findAll();
        if(doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable("id") Integer id){
        Doctor doctorFound = service.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(service);
    }

    @GetMapping("/specialty/{id}/doctor")
    public ResponseEntity<?> getAllDoctorsByCategory(@PathVariable("id") Integer id){
        List<Doctor> doctors = service.findBySpecialtyId(id);
        if(doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors for this specialty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @PostMapping("/specialty/{id}/doctor")
    public ResponseEntity<?> createDoctor(@PathVariable("id") Integer id,  @RequestBody Doctor doctor){
        Specialty specialty = specialtyService.findById(id);
        doctor.setSpecialty(specialty);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doctor));
    }

    //@PutMapping("/specialty/{specialtyId}/doctor/{doctorId}")
    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity<?> editDoctor(
                                        @PathVariable("doctorId") Integer doctorId,
                                        @RequestBody Doctor doctor){
        Doctor doctorEdited = service.findById(doctorId);
        if(doctorEdited == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        doctorEdited.setName(doctor.getName());
        doctorEdited.setLastName(doctor.getLastName());
        doctorEdited.setDocument(doctor.getDocument());
        doctorEdited.setPhone(doctor.getPhone());
        doctorEdited.setEmail(doctor.getEmail());
        doctorEdited.setAddress(doctor.getAddress());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doctorEdited));
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id){
        Doctor doctorFound = service.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}

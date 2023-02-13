package com.microservice.service.controller.query;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.entity.Doctor;
import com.microservice.service.entity.Specialty;
import com.microservice.service.services.command.DoctorCommandService;
import com.microservice.service.services.command.SpecialtyCommandService;
import com.microservice.service.services.query.DoctorQueryService;
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
public class DoctorQueryController {
    @Autowired
    private DoctorQueryService doctorservice;

    @GetMapping("/public/doctor")
    public ResponseEntity<?> getAllDoctors(){
        log.info("Inside method to get all doctors");
        List<DoctorGetDTO> doctors = doctorservice.findAll();
        if(doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/public/doctor/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable("id") Integer id){
        log.info("Inside method to get one doctor by id");
        DoctorGetDTO doctorFound = doctorservice.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctorFound);
    }

    @GetMapping("/public/specialty/{id}/doctor")
    public ResponseEntity<?> getAllDoctorsByCategory(@PathVariable("id") Integer id){
        log.info("Inside method to get all doctors by specialty");
        List<DoctorGetDTO> doctors = doctorservice.findBySpecialtyId(id);
        if(doctors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not doctors for this specialty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }


}

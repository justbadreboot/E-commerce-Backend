package com.microservice.service.controller.command;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.dto.DoctorPostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.services.command.DoctorCommandService;
import com.microservice.service.services.query.DoctorQueryService;
import com.microservice.service.services.query.SpecialtyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DoctorCommandController {
    @Autowired
    private DoctorCommandService doctorCommandService;

    @Autowired
    private DoctorQueryService doctorQueryService;

    @Autowired
    private SpecialtyQueryService specialtyQueryService;

    @PostMapping("/specialty/{id}/doctor")
    public ResponseEntity<?> createDoctor(@PathVariable("id") Integer id,  @RequestBody DoctorPostDTO doctorDto){
        SpecialtyGetDTO specialtyDto = specialtyQueryService.findById(id);
        if(specialtyDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorCommandService.save(doctorDto, specialtyDto));
    }

    @PutMapping("/specialty/{id}/doctor")
    public ResponseEntity<?> editDoctor(@PathVariable("id") Integer id,  @RequestBody DoctorPostDTO doctorDto){
        SpecialtyGetDTO specialtyDto = specialtyQueryService.findById(id);
        if(specialtyDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorCommandService.save(doctorDto, specialtyDto));
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id){
        DoctorGetDTO doctorFound = doctorQueryService.findById(id);
        if(doctorFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found");
        }
        doctorCommandService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

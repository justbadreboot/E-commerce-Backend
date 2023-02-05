package com.microservice.service.controller;

import com.microservice.service.entity.Appointment;
import com.microservice.service.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(value = "*")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<?> findAllAppointment(){
        List<Appointment> appointments = appointmentService.findAll();
        if(appointments.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No appointments yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAppointmentById(@PathVariable("id") Integer id){
        Optional<Appointment> appointmentFound =  appointmentService.findById(id);
        if(!appointmentFound.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentFound);
    }

    @PostMapping
    public ResponseEntity<?> createEditAppointment(@RequestBody Appointment appointment){
        Appointment appointmentAdded = appointmentService.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentAdded);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") Integer id){
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

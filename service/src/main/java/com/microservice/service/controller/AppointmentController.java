package com.microservice.service.controller;

import com.microservice.service.entity.Appointment;
import com.microservice.service.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(value = "*")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> findAllAppointment(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment findAppointmentById(@PathVariable("id") Integer id){
        return appointmentService.findById(id).get();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    @PutMapping
    public Appointment editAppointment(@RequestBody Appointment appointment){
        return appointmentService.update(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable("id") Integer id){
        appointmentService.delete(id);
    }

}

package com.microservice.service.controller.command;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.dto.AppointmentPostDTO;
import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.services.command.AppointmentCommandService;
import com.microservice.service.services.query.AppointmentQueryService;
import com.microservice.service.services.query.ServiceQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
@Slf4j
public class AppointmentCommandController {
    @Autowired
    private AppointmentCommandService appointmentService;
    @Autowired
    private AppointmentQueryService appointmentQueryService;
    @Autowired
    private ServiceQuery serviceQuery;

    @PostMapping("/cliente/service/{id}/appointment")
    public ResponseEntity<?> createAppointment(@PathVariable("id") Integer id,
                                               @RequestBody AppointmentPostDTO appointmentDto){
        log.info("Inside method to create an appointment");
        ServiceGetDto serviceDto = serviceQuery.findById(id);
        if(serviceDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        AppointmentGetDTO appointmentAdded = appointmentService.save(appointmentDto, serviceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentAdded);
    }

    @PutMapping("/cliente/service/{id}/appointment")
    public ResponseEntity<?> editAppointment(@PathVariable("id") Integer id,
                                             @RequestBody AppointmentPostDTO appointmentDto){
        log.info("Inside method to edit an appointment");
        ServiceGetDto serviceDto = serviceQuery.findById(id);
        if(serviceDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        AppointmentGetDTO appointmentAdded = appointmentService.save(appointmentDto, serviceDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentAdded);
    }

    @DeleteMapping("/cliente/appointment/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") Integer id){
        log.info("Inside method to delete an appointment");
        AppointmentGetDTO appFound = appointmentQueryService.findById(id);
        if(appFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
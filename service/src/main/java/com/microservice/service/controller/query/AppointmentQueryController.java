package com.microservice.service.controller.query;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.services.query.AppointmentQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
@Slf4j
public class AppointmentQueryController {
    @Autowired
    private AppointmentQueryService appointmentService;

    @GetMapping("/admin/appointment")
    public ResponseEntity<?> findAllAppointment(){
        log.info("Inside method to get all appointments");
        List<AppointmentGetDTO> appointments = appointmentService.findAll();
        if(appointments.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No appointments yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @GetMapping("/cliente/appointment/{id}")
    public ResponseEntity<?> findAppointmentById(@PathVariable("id") Integer id){
        log.info("Inside method to get one appointment by id");
        AppointmentGetDTO appointmentFound =  appointmentService.findById(id);
        if(appointmentFound== null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentFound);
    }

    @GetMapping("/cliente/appointment/client/{clientId}")
    public ResponseEntity<?> findAppointmentByClientId(@PathVariable("clientId") Integer id){
        log.info("Inside method to get all appointments by client id");
        List<AppointmentGetDTO> appointmentsFound =  appointmentService.findByClientId(id);
        if(appointmentsFound== null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentsFound);
    }

}
package com.microservice.service.controller.query;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.entity.Appointment;
import com.microservice.service.services.command.AppointmentCommandService;
import com.microservice.service.services.query.AppointmentQueryService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(value = "*")
@Slf4j
public class AppointmentQueryController {
    @Autowired
    private AppointmentQueryService appointmentService;

    @GetMapping
    public ResponseEntity<?> findAllAppointment(){
        log.info("Inside method to get all appointments");
        List<AppointmentGetDTO> appointments = appointmentService.findAll();
        if(appointments.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No appointments yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAppointmentById(@PathVariable("id") Integer id){
        log.info("Inside method to get one appointment by id");
        AppointmentGetDTO appointmentFound =  appointmentService.findById(id);
        if(appointmentFound== null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentFound);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<?> findAppointmentByClientId(@PathVariable("clientId") Integer id){
        log.info("Inside method to get all appointments by client id");
        List<AppointmentGetDTO> appointmentsFound =  appointmentService.findByClientId(id);
        if(appointmentsFound== null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointmentsFound);
    }

}

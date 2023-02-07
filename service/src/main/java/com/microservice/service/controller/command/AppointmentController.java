package com.microservice.service.controller.command;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.dto.AppointmentPostDTO;
import com.microservice.service.entity.Appointment;
import com.microservice.service.services.command.AppointmentCommandService;
import com.microservice.service.services.query.AppointmentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(value = "*")
public class AppointmentController {
    @Autowired
    private AppointmentCommandService appointmentService;

    @Autowired
    private AppointmentQueryService appointmentQueryService;

    @PostMapping
    public ResponseEntity<?> createEditAppointment(@RequestBody AppointmentPostDTO appointmentDto){
        Appointment appointmentAdded = appointmentService.save(appointmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentAdded);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable("id") Integer id){
        AppointmentGetDTO appFound = appointmentQueryService.findById(id);
        if(appFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found");
        }
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

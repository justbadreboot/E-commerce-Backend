package com.microservice.service.controller.command;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.dto.ServicePostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.services.command.ServiceCommand;
import com.microservice.service.services.query.ServiceQuery;
import com.microservice.service.services.query.SpecialtyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class ServiceCommandController {

    @Autowired
    private ServiceCommand serviceCommand;

    @Autowired
    private ServiceQuery serviceQuery;

    @Autowired
    private SpecialtyQueryService specialtyQueryService;

    @PostMapping("/specialty/{id}/service")
    public ResponseEntity<?> createService(@PathVariable("id") Integer id, @RequestBody ServicePostDTO srvDto){
        SpecialtyGetDTO specialtyFound = specialtyQueryService.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCommand.create(srvDto, specialtyFound));
    }

    @DeleteMapping("service/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Integer id){
        ServiceGetDto serviceFound = serviceQuery.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        serviceCommand.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}

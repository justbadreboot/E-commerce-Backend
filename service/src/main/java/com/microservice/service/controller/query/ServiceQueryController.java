package com.microservice.service.controller.query;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.services.query.ServiceQuery;
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
public class ServiceQueryController {

    @Autowired
    private ServiceQuery service;

    @GetMapping("/public/service")
    public ResponseEntity<?> findAllServices(){
        log.info("Inside method to get all services");
        List<ServiceGetDto> services = service.findAll();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @GetMapping("/public/service/main")
    public ResponseEntity<?> findMainServices(){
        log.info("Inside method to get four main services");
        List<ServiceGetDto> services = service.findMainService();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @GetMapping("/public/service/search/{name}")
    public ResponseEntity<?> findServicesByName(@PathVariable("name") String name){
        log.info("Inside method to get services by name");
        List<ServiceGetDto> services = service.findByName(name);
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services with name: "+name);
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @GetMapping("/public/service/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable("id") Integer id){
        log.info("Inside method to get one service by id");
        ServiceGetDto serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceFound);
    }

    @GetMapping("/public/specialty/{id}/service")
    public ResponseEntity<?> findServiceBySpecialty(@PathVariable("id") Integer id){
        log.info("Inside method to get all services by specialty");
        List<ServiceGetDto> services = service.findBySpecialtyId(id);
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services with this specialty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

}

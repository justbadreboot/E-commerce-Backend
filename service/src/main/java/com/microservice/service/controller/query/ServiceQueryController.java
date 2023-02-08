package com.microservice.service.controller.query;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.entity.Service;
import com.microservice.service.entity.Specialty;
import com.microservice.service.services.command.ServiceCommand;
import com.microservice.service.services.command.SpecialtyCommandService;
import com.microservice.service.services.query.ServiceQuery;
import com.microservice.service.services.query.SpecialtyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class ServiceQueryController {

    @Autowired
    private ServiceQuery service;

    @GetMapping("/service")
    public ResponseEntity<?> findAllServices(){
        List<ServiceGetDto> services = service.findAll();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @GetMapping("/service/main")
    public ResponseEntity<?> findMainServices(){
        List<ServiceGetDto> services = service.findMainService();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @GetMapping("service/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable("id") Integer id){
        ServiceGetDto serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceFound);
    }

    @GetMapping("/specialty/{id}/service")
    public ResponseEntity<?> findServiceBySpecialty(@PathVariable("id") Integer id){
        List<ServiceGetDto> services = service.findBySpecialtyId(id);
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services with this specialty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

}

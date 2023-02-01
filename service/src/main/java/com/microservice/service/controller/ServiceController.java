package com.microservice.service.controller;

import com.microservice.service.entity.Service;
import com.microservice.service.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private IService service;

    @GetMapping
    public ResponseEntity<?> findAllServices(){
        List<Service> services = service.findAll();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable("id") Integer id){
        Service serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceFound);
    }

    @PostMapping
    public ResponseEntity<?> createService(@RequestBody Service srv){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(srv));
    }

    @PutMapping
    public ResponseEntity<?> editService(@RequestBody Service srv){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(srv));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Integer id){
        Service serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}

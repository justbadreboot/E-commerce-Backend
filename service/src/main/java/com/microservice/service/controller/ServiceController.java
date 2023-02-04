package com.microservice.service.controller;

import com.microservice.service.entity.Service;
import com.microservice.service.entity.Specialty;
import com.microservice.service.services.IService;
import com.microservice.service.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private IService service;

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/service")
    public ResponseEntity<?> findAllServices(){
        List<Service> services = service.findAll();
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }
    @GetMapping("service/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable("id") Integer id){
        Service serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceFound);
    }

    @GetMapping("/specialty/{id}/service")
    public ResponseEntity<?> findServiceBySpecialty(@PathVariable("id") Integer id){
        List<Service> services = service.findBySpecialtyId(id);
        if(services.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not services with this specialty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(services);
    }

    @PostMapping("/specialty/{id}/service")
    public ResponseEntity<?> createService(@PathVariable("id") Integer id, @RequestBody Service srv){
        Specialty specialtyFound = specialtyService.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not exists");
        }
        srv.setSpecialty(specialtyFound);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(srv));
    }

    @PutMapping("/service/{serviceId}")
    public ResponseEntity<?> editService(@PathVariable("serviceId") Integer serviceId,
                                         @RequestBody Service srv){
        Service serviceFound = service.findById(serviceId);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.update(serviceFound));
    }

    @DeleteMapping("service/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Integer id){
        Service serviceFound = service.findById(id);
        if(serviceFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
}

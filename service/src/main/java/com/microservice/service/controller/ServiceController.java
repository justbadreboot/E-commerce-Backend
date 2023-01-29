package com.microservice.service.controller;

import com.microservice.service.entity.Service;
import com.microservice.service.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private IService service;

    @GetMapping
    public List<Service> findAllServices(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Service findServiceById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Service createService(Service srv){
        return service.create(srv);
    }

    @PutMapping
    public Service editService(Service srv){
        return service.update(srv);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable("id") Integer id){
        service.remove(id);
    }
}

package com.microservice.client.controller.command;

import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.service.command.ClientCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class ClientCommandController {

    @Autowired
    private ClientCommandService service;

    @PostMapping("/public/client")
    public ResponseEntity<?> createClient(@RequestBody @Valid ClientPostDTO clientPostDTO) {
        log.info("Inside method to create a client");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

    @PutMapping("/cliente/client")
    public ResponseEntity<?> editClient(@RequestBody @Valid ClientPostDTO clientPostDTO) {
        log.info("Inside method to edit a client");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

}
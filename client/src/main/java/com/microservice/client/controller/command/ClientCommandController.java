package com.microservice.client.controller.command;

import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.service.command.ClientCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/client")
public class ClientCommandController {

    @Autowired
    private ClientCommandService service;

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody @Valid ClientPostDTO clientPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

    @PutMapping
    public ResponseEntity<?> editClient(@Valid @RequestBody ClientPostDTO clientPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable("clientId") @Min(1) Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client deleted");
    }

}

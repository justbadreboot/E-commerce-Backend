package com.microservice.client.controller;

import com.microservice.client.entity.Client;
import com.microservice.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<?> findAllClients(){
        List<Client> clients = service.findAll();
        if(clients.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not clients yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> findClientById(@PathVariable("clientId") @Min(1) int clientId){
        Client clientFound = service.findById(clientId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result) {
        if(result.hasErrors()) {
            return validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<?> editClient(@Valid @RequestBody Client client, BindingResult result, @PathVariable int clientId){
        if(result.hasErrors()) {
            return validate(result);
        }
        Client clientFound = service.findById(clientId);
        if(clientFound != null) {
            clientFound.setFirstName(client.getFirstName());
            clientFound.setLastName(client.getLastName());
            clientFound.setPhone(client.getPhone());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientFound));
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error->{
            errors.put(error.getField(), "The field: "+error.getField() +" "+error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}

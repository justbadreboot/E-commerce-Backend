package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.service.query.ClientQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class ClientQueryController {

    @Autowired
    private ClientQueryService service;

    @GetMapping("/admin/client")
    public ResponseEntity<?> findAllClients(){
        log.info("Inside method to get all clients");
        List<ClientGetDTO> clientsDto = service.findAll();
        if(clientsDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not clients yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientsDto);
    }

    @GetMapping("/public/client/{clientId}")
    public ResponseEntity<?> findClientById(@PathVariable("clientId") @Min(1) int clientId){
        log.info("Inside method to get one client by id");
        ClientGetDTO clientFound = service.findById(clientId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }
    @GetMapping("/repartidor/client/{clientId}")
    public ResponseEntity<?> findClientByIdRep(@PathVariable("clientId") @Min(1) int clientId){
        log.info("Inside method to get one client by id");
        ClientGetDTO clientFound = service.findById(clientId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @GetMapping("/public/client/filter/{document}")
    public ResponseEntity<?> findClientByDocument(@PathVariable("document") String document){
        log.info("Inside method to get one client by document number");
        ClientGetDTO clientFound = service.findByDocument(document);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @GetMapping("/cliente/client/user/{userId}")
    public ResponseEntity<?> findClientByUserId(@PathVariable("userId") Integer userId){
        log.info("Inside method to get one clients by user id");
        ClientGetDTO clientFound = service.findByUserId(userId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @GetMapping("/admin/client/count")
    public ResponseEntity<?> getCountClient(){
        log.info("Inside method to delete a client by id");
        return ResponseEntity.status(HttpStatus.OK).body(service.countTotalClient());
    }

}
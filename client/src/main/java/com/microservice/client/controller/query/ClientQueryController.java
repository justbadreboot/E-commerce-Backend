package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.service.query.ClientQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/client")
public class ClientQueryController {

    @Autowired
    private ClientQueryService service;

    @GetMapping
    public ResponseEntity<?> findAllClients(){
        List<ClientGetDTO> clientsDto = service.findAll();
        if(clientsDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not clients yet");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientsDto);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<?> findClientById(@PathVariable("clientId") @Min(1) int clientId){
        ClientGetDTO clientFound = service.findById(clientId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @GetMapping("filter/{document}")
    public ResponseEntity<?> findClientByDocument(@PathVariable("document") String document){
        ClientGetDTO clientFound = service.findByDocument(document);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<?> findClientByUserId(@PathVariable("userId") Integer userId){
        ClientGetDTO clientFound = service.findByUserId(userId);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientFound);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCountClient(){
        return ResponseEntity.status(HttpStatus.OK).body(service.countTotalClient());
    }


}

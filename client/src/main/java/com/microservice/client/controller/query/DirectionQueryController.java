package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.service.query.ClientQueryService;
import com.microservice.client.service.query.DirectionQueryService;
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
public class DirectionQueryController {

    @Autowired
    private DirectionQueryService directionService;

    @Autowired
    private ClientQueryService clientService;

    @GetMapping("/client/{id}/direction")
    public ResponseEntity<?> findAllDirections(@PathVariable("id") Integer id){
        log.info("Inside method to get all directions");
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        List<DirectionGetDTO> directionsDto = directionService.findByClientId(id);
        return ResponseEntity.status(HttpStatus.OK).body(directionsDto);
    }

    @GetMapping("/client/{id}/direction/first")
    public ResponseEntity<?> findFirstDirectionByClient(@PathVariable("id") Integer id){
        log.info("Inside method to get first client's direction");
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionService.findFirstByClientId(id));
    }

    @GetMapping("/client/{id}/direction/custom")
    public ResponseEntity<?> findAllDirectionsByClientCustom(@PathVariable("id") Integer id){
        log.info("Inside method to get all custom directions by client id");
        if(clientService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionService.findByClientIdCustom(id));
    }

    @GetMapping("/direction/{id}")
    public ResponseEntity<?> findDirectionById(@PathVariable("id") Integer id){
        log.info("Inside method to remove a direction");
        DirectionGetDTO directionFound =  directionService.findById(id);
        if(directionFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Direction not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionFound);
    }

}
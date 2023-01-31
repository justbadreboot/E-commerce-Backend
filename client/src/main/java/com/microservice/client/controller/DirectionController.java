package com.microservice.client.controller;

import com.microservice.client.entity.Client;
import com.microservice.client.entity.Direction;
import com.microservice.client.service.ClientService;
import com.microservice.client.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DirectionController {

    @Autowired
    private DirectionService directionService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/client/{id}/direction")
    public ResponseEntity<?> findAllDirectionsByClient(@PathVariable("id") Integer id){
        Client clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        List<Direction> directions = clientFound.getDirections();
        return ResponseEntity.status(HttpStatus.OK).body(directions);
    }

    @GetMapping("/direction/{id}")
    public ResponseEntity<?> findDirectionById(@PathVariable("id") Integer id){
        Direction directionFound =  directionService.findById(id);
        if(directionFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Direction not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionService.findById(id));
    }

    @PostMapping("/client/{id}/direction")
    public ResponseEntity<?> createDirection(@Valid @PathVariable("id") Integer id, @RequestBody Direction direction) {
        Client clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        clientFound.getDirections().add(direction);
        Direction dir = directionService.save(direction);
        return ResponseEntity.status(HttpStatus.CREATED).body(dir);
    }

    @PutMapping("/direction/{id}")
    public ResponseEntity<?> editDirection(@PathVariable("id") Integer id, @RequestBody Direction direction){
        Direction directionFound = directionService.findById(id);
        if(directionFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Direction not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionService.save(direction));
    }

    @DeleteMapping("/direction/{id}")
    public ResponseEntity<?> deleteDirection(@PathVariable("id") Integer id) {
        directionService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }




}

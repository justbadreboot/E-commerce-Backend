package com.microservice.client.controller.command;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionPostDTO;
import com.microservice.client.entity.Client;
import com.microservice.client.entity.Direction;
import com.microservice.client.service.command.DirectionCommandService;
import com.microservice.client.service.query.ClientQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DirectionCommandController {

    @Autowired
    private DirectionCommandService directionService;

    @Autowired
    private ClientQueryService clientService;

    @PostMapping("/client/{id}/direction")
    public ResponseEntity<?> createEditDirection(@Valid @PathVariable("id") Integer id, @RequestBody DirectionPostDTO directionPostDTO) {
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        directionPostDTO.setClient(clientFound);
        Direction directionToAdd = directionService.save(directionPostDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(directionToAdd);
    }

    @DeleteMapping("/direction/{id}")
    public ResponseEntity<?> deleteDirection(@PathVariable("id") Integer id) {
        directionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}

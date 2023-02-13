package com.microservice.client.controller.command;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.dto.DirectionPostDTO;
import com.microservice.client.service.command.DirectionCommandService;
import com.microservice.client.service.query.ClientQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DirectionCommandController {

    @Autowired
    private DirectionCommandService directionService;

    @Autowired
    private ClientQueryService clientService;

    @PostMapping("/cliente/client/{id}/direction")
    public ResponseEntity<?> createDirection(@PathVariable("id") @Min(1) Integer id, @RequestBody @Valid DirectionPostDTO directionPostDTO) {
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        DirectionGetDTO directionToAdd = directionService.save(directionPostDTO, clientFound);
        return ResponseEntity.status(HttpStatus.CREATED).body(directionToAdd);
    }

    @PutMapping("cliente/client/{id}/direction")
    public ResponseEntity<?> editDirection(@Valid @PathVariable("id") Integer id, @RequestBody @Valid DirectionPostDTO directionPostDTO) {
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        DirectionGetDTO directionToAdd = directionService.save(directionPostDTO, clientFound);
        return ResponseEntity.status(HttpStatus.CREATED).body(directionToAdd);
    }

    @DeleteMapping("/cliente/direction/{id}")
    public ResponseEntity<?> deleteDirection(@PathVariable("id") @Min(1) Integer id) {
        directionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}

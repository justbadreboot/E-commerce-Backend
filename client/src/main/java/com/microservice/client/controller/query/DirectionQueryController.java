package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.entity.Client;
import com.microservice.client.entity.Direction;
import com.microservice.client.service.query.ClientQueryService;
import com.microservice.client.service.query.DirectionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
public class DirectionQueryController {

    @Autowired
    private DirectionQueryService directionService;

    @Autowired
    private ClientQueryService clientService;

    @GetMapping("/client/{id}/direction")
    public ResponseEntity<?> findAllDirectionsByClient(@PathVariable("id") Integer id){
        ClientGetDTO clientFound = clientService.findById(id);
        if(clientFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        List<DirectionGetDTO> directionsDto = directionService.findByClientId(id);
        return ResponseEntity.status(HttpStatus.OK).body(directionsDto);
    }

    @GetMapping("/direction/{id}")
    public ResponseEntity<?> findDirectionById(@PathVariable("id") Integer id){
        DirectionGetDTO directionFound =  directionService.findById(id);
        if(directionFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Direction not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(directionFound);
    }
}

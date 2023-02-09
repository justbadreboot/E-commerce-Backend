package com.microservice.client.controller.command;

import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.service.command.ClientCommandService;
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
public class ClientCommandController {

    @Autowired
    private ClientCommandService service;

    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody ClientPostDTO clientPostDTO, BindingResult result) {
        if(result.hasErrors()) {
            return validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

    @PutMapping
    public ResponseEntity<?> editClient(@Valid @RequestBody ClientPostDTO clientPostDTO, BindingResult result) {
        if(result.hasErrors()) {
            return validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clientPostDTO));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable("clientId") Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client deleted");
    }

    private ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error->{
            errors.put(error.getField(), "The field: "+error.getField() +" "+error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}

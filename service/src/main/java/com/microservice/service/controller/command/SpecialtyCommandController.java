package com.microservice.service.controller.command;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.dto.SpecialtyPostDTO;
import com.microservice.service.services.command.SpecialtyCommandService;
import com.microservice.service.services.query.SpecialtyQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/specialty")
public class SpecialtyCommandController {
    @Autowired
    private SpecialtyCommandService commandService;

    @Autowired
    private SpecialtyQueryService queryService;

    @PostMapping
    public ResponseEntity<?> createSpecialty(@RequestBody SpecialtyPostDTO specialtyDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(specialtyDto));
    }

    @PutMapping
    public ResponseEntity<?> editSpecialty(@RequestBody SpecialtyPostDTO specialtyDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(specialtyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable("id") Integer id){
        SpecialtyGetDTO specialtyFound = queryService.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found");
        }
        commandService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

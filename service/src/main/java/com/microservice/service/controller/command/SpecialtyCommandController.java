package com.microservice.service.controller.command;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.dto.SpecialtyPostDTO;
import com.microservice.service.services.command.SpecialtyCommandService;
import com.microservice.service.services.query.SpecialtyQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api")
@Slf4j
public class SpecialtyCommandController {
    @Autowired
    private SpecialtyCommandService commandService;

    @Autowired
    private SpecialtyQueryService queryService;

    @PostMapping("/admin/specialty")
    public ResponseEntity<?> createSpecialty(@RequestBody SpecialtyPostDTO specialtyDto){
        log.info("Inside method to create a specialty");
        return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(specialtyDto));
    }

    @PutMapping("/admin/specialty")
    public ResponseEntity<?> editSpecialty(@RequestBody SpecialtyPostDTO specialtyDto){
        log.info("Inside method to edit a specialty");
        return ResponseEntity.status(HttpStatus.CREATED).body(commandService.save(specialtyDto));
    }

    @DeleteMapping("/admin/specialty/{id}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable("id") Integer id){
        log.info("Inside method to delete a specialty");
        SpecialtyGetDTO specialtyFound = queryService.findById(id);
        if(specialtyFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found");
        }
        commandService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

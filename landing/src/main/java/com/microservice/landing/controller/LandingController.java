package com.microservice.landing.controller;

import com.microservice.landing.entity.Landing;
import com.microservice.landing.repository.LandingRepository;
import com.microservice.landing.service.LandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/landing")
public class LandingController {
    @Autowired
    private LandingService landingService;
    @Autowired
    private LandingRepository landingRepository;

    @GetMapping()
    public ResponseEntity<List<Landing>> informationGet(){
        return ResponseEntity.ok(landingService.information());
    }


    @PutMapping("{id}")
    public ResponseEntity<?>editInfo(@RequestBody Landing landing, @RequestParam Integer id){
        Optional<Landing> edit = landingService.editInfoById(id);
        if (edit.isPresent()){
            Landing landingDB = edit.get();
            landingDB.setName(landing.getName());
            landingDB.setDescription(landing.getDescription());
            landingDB.setAddress(landing.getAddress());
            landingDB.setMission(landing.getMission());
            landingDB.setVision(landing.getVision());
            landingDB.setPhone(landing.getPhone());
            return ResponseEntity.status(HttpStatus.CREATED).body(landingRepository.save(landingDB));
        }
        return ResponseEntity.notFound().build();
    }

}

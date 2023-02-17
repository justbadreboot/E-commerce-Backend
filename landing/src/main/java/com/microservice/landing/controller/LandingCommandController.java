package com.microservice.landing.controller;

import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;
import com.microservice.landing.repository.LandingRepository;
import com.microservice.landing.service.commands.LandingCommandService;
import com.microservice.landing.service.query.LandingQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/landing")
@CrossOrigin(value = "*")
public class LandingCommandController {

    @Autowired
    private LandingCommandService landingCommandService;
    @Autowired
    private LandingQueryService landingQueryService;

    @Autowired
    private LandingRepository landingRepository;


    @PutMapping("/{id}")
    public ResponseEntity<?> editInfo(@RequestBody LandingPostDTO landingPostDTO, @RequestParam(value = "id")Integer id){
        Optional<Landing> optionalLanding = landingQueryService.readLandingById(id);
        if (optionalLanding.isPresent()){
            Landing landingBd= optionalLanding.get();
            landingCommandService.updateLandingInformation(landingPostDTO, landingBd);
            return ResponseEntity.status(HttpStatus.CREATED).body(landingRepository.save(landingBd));
        }
        log.error("No se pudo realizar la petición");
        return ResponseEntity.notFound().build();
    }
}

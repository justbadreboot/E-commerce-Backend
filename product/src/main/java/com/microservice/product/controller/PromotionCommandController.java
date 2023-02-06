package com.microservice.product.controller;

import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.entity.Promotion;
import com.microservice.product.repository.PromotionRepository;
import com.microservice.product.service.command.PromotionCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin(value = "*")
public class PromotionCommandController {

    @Autowired
    private PromotionCommandService promotionCommandService;
    @Autowired
    private PromotionRepository promotionRepository;

    @PostMapping
    public ResponseEntity<?> addPromotion(@Valid @RequestBody PromotionPostDTO promotionPostDTO){
        promotionCommandService.savePromotion(promotionPostDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPromotion(@RequestBody PromotionPostDTO promotionPostDTO, @PathVariable(value = "id") Integer id){
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        if (optionalPromotion.isPresent()){
            Promotion promotionBD = optionalPromotion.get();
            promotionCommandService.updatePromotion(promotionBD, promotionPostDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(promotionRepository.save(promotionBD));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion (@PathVariable(value = "id") Integer id){
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        if (optionalPromotion.isPresent()){
            promotionCommandService.deletePromotion(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}

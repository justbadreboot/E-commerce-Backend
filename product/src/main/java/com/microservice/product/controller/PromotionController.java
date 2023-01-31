package com.microservice.product.controller;

import com.microservice.product.entity.Promotion;
import com.microservice.product.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin(value = "*")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping("/all")
    public List<Promotion> allCategory(){
        return promotionService.allPromotion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> promotionIdInformation(@RequestParam(value = "id") Integer id){
        Optional<Promotion> promotionOptional = promotionService.byId(id);
        if (promotionOptional.isPresent()){
            return ResponseEntity.ok(promotionOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> addPromotion(@Valid @RequestBody Promotion promotion){
        return ResponseEntity.status(HttpStatus.CREATED).body(promotionService.savePromotion(promotion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPromotion(@RequestBody Promotion promotion, @PathVariable(value = "id") Integer id){
        Optional<Promotion> promotionOptional = promotionService.byId(id);
        if (promotionOptional.isPresent()){
            Promotion promotionDB = promotionOptional.get();
            promotionDB.setName(promotion.getName());
            promotionDB.setDescription(promotion.getDescription());
            promotionDB.setDiscount(promotion.getDiscount());
            promotionDB.setEndDate(promotion.getEndDate());
            promotionDB.setEndDate(promotion.getEndDate());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(promotionService.savePromotion(promotionDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion(@RequestParam(value = "id") Integer id){
        Optional<Promotion> promotionOptional = promotionService.byId(id);
        if (promotionOptional.isPresent()){
            promotionService.deletePromotion(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

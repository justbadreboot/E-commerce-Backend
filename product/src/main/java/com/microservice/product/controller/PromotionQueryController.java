package com.microservice.product.controller;

import com.microservice.product.entity.Promotion;
import com.microservice.product.service.query.PromotionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/promotion")
//@CrossOrigin(origins = "**", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@CrossOrigin(origins = "*")
public class PromotionQueryController {

    @Autowired
    private PromotionQueryService promotionQueryService;

    @GetMapping("/all")
    public List<Promotion> allPromotion() {
        return promotionQueryService.allPromotion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> promotionIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Promotion> promotionOptional = promotionQueryService.byId(id);
        if (promotionOptional.isPresent()){
            return ResponseEntity.ok(promotionOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}

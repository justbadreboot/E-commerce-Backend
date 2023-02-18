package com.microservice.product.controller;

import com.microservice.product.entity.Promotion;
import com.microservice.product.service.query.PromotionQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Tag(name = "Promotion Query")
@RestController
@RequestMapping("/api/public/promotion")
@CrossOrigin(origins = "*")
public class PromotionQueryController {

    @Autowired
    private PromotionQueryService promotionQueryService;
    @Operation(summary = "Obtener todas la promociones")
    @GetMapping("/all")
    public List<Promotion> allPromotion() {
        return promotionQueryService.allPromotion();
    }

    @Operation(summary = "Obtener promocion por Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> promotionIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Promotion> promotionOptional = promotionQueryService.byId(id);
        if (promotionOptional.isPresent()){
            log.warn("Promocion obtenida");
            return ResponseEntity.ok(promotionOptional.get());
        }
        log.info("no se pudo encontrar la informacion");
        return ResponseEntity.notFound().build();
    }
}

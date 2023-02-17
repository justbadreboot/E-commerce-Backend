package com.microservice.product.controller;


import com.microservice.product.entity.Promotion;
import com.microservice.product.repository.PromotionRepository;
import com.microservice.product.service.command.PromotionCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Tag(name = "Promotion Commands")
@RestController
@RequestMapping("/api/admin/promotion")
@CrossOrigin(origins = "*")
public class PromotionCommandController {

    @Autowired
    private PromotionCommandService promotionCommandService;
    @Autowired
    private PromotionRepository promotionRepository;

    @Operation(summary = "Agregar promociones")
    @PostMapping
    public ResponseEntity<?> addPromotion(@Valid @RequestBody Promotion promotionPostDTO){
        promotionRepository.save(promotionPostDTO);
        log.info("Promocion guardada");
        return ResponseEntity.ok("Create ok");
    }

    @Operation(summary = "Editar promociones por ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> editPromotion(@RequestBody Promotion promotionPostDTO, @PathVariable(value = "id") Integer id){
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        if (optionalPromotion.isPresent()){
            Promotion promotionBD = optionalPromotion.get();
            promotionBD.setName(promotionPostDTO.getName());
            promotionBD.setDescription(promotionPostDTO.getDescription());
            promotionBD.setImage(promotionPostDTO.getImage());
            promotionBD.setEndDate(promotionPostDTO.getEndDate());
            promotionBD.setStartDate(promotionPostDTO.getStartDate());
            promotionBD.setPromotionTypes(promotionPostDTO.getPromotionTypes());
            promotionBD.setProduct(promotionPostDTO.getProduct());
            //promotionCommandService.mapperPromotion(promotionBD, promotionPostDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(promotionRepository.save(promotionBD));
        }
        log.warn("No se pudo actualizar");
        return ResponseEntity.notFound().build();
    }
    @Operation(summary = "Elimar promociones por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePromotion (@PathVariable(value = "id") Integer id){
        Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
        if (optionalPromotion.isPresent()){
            promotionCommandService.deletePromotion(id);
            log.warn("Promocion eliminada");
            return ResponseEntity.ok().build();
        }
        log.info("No se pudo eliminar");
        return ResponseEntity.notFound().build();
    }


}

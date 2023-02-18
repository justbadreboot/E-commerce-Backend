package com.microservice.product.controller;

import com.microservice.product.entity.Category;
import com.microservice.product.mapper.CategoryMapper;
import com.microservice.product.service.query.CategoryQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Tag(name = "Category Query")
@RequestMapping("/api/public/category")
@CrossOrigin(origins = "*")
public class CategoryQueryController {
    @Autowired
    private CategoryQueryService categoryQueryService;

    @Autowired
    private CategoryMapper categoryMapper;
    @Operation(summary = "Obtener todas las categorías")
    @GetMapping("/all")
    public List<?> allCategory(){
        log.info("Categoria obtenida");
        return categoryMapper.listCategoryEntityToDTO(categoryQueryService.allCategory());
    }

    @Operation(summary = "Obtener categoría por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> categoryIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryQueryService.byId(id);
        if (categoryOptional.isPresent()){
            log.info("Información obtenida");
            return ResponseEntity.ok(categoryMapper.categgoryEntityToDTO(categoryOptional.get()));
        }
        log.error("No se pudo encontrar la categoría");
        return ResponseEntity.notFound().build();
    }


}

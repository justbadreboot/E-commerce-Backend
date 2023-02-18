package com.microservice.product.controller;

import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.service.command.CategoryCommandService;
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
@RestController
@Tag(name = "Category Command")
@RequestMapping("/api/admin/category")
@CrossOrigin(value = "*")
public class CategoryCommandController {

    @Autowired
    private CategoryCommandService categoryCommandService;

    @Autowired
    private CategoryRepository categoryRepository;


    @Operation(summary = "Agregar categoría")
    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryPostDTO categoryPostDTO){
        categoryCommandService.saveCategory(categoryPostDTO);
        log.info("categoria creada");
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar categoría por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            categoryCommandService.deleteCategory(id);
            log.info("categoria eliminada con exito");
            return ResponseEntity.ok().build();
        }
        log.error("no se encontró el id y no se pudo eliminar");
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Editar Categpria por ID")
    @PutMapping("/{id}")
    public ResponseEntity<?> editCategory(@PathVariable(value = "id") Integer id,@Valid @RequestBody CategoryPostDTO categoryPostDTO){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            Category categoryBD = categoryOptional.get();
            categoryCommandService.updateCategory(categoryBD, categoryPostDTO);
            log.info("Categoria actualizada");
                return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(categoryBD));
        }
        log.error("Categoria no encontrada");
        return ResponseEntity.notFound().build();
    }


}

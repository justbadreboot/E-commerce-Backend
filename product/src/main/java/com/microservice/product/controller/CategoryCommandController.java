package com.microservice.product.controller;

import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.service.command.CategoryCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/category")
@CrossOrigin(value = "*")
public class CategoryCommandController {

    @Autowired
    private CategoryCommandService categoryCommandService;

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryPostDTO categoryPostDTO){
        categoryCommandService.saveCategory(categoryPostDTO);
        return ResponseEntity.ok().build(); // o .status(HttpStatus.CREATED).body("Categoria creada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            categoryCommandService.deleteCategory(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCategory(@PathVariable(value = "id") Integer id,@Valid @RequestBody CategoryPostDTO categoryPostDTO){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()){
            Category categoryBD = categoryOptional.get();
            categoryCommandService.updateCategory(categoryBD, categoryPostDTO);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(categoryBD));
        }
        return ResponseEntity.notFound().build();
    }


}

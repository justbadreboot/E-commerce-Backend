/*package com.microservice.product.controller;

import com.microservice.product.entity.Category;
import com.microservice.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(value = "*")
public class CategoyController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> allCategory(){
        return categoryService.allCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> categryIdInformation(@RequestParam(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryService.byId(id);
        if (categoryOptional.isPresent()){
            return ResponseEntity.ok(categoryOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCategory(@RequestBody Category category, @PathVariable(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryService.byId(id);
        if (categoryOptional.isPresent()){
            Category categoryDB = categoryOptional.get();
            categoryDB.setName(category.getName());
            categoryDB.setDescription(category.getDescription());
            categoryDB.setImage(category.getImage());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.saveCategory(categoryDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@RequestParam(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryService.byId(id);
        if (categoryOptional.isPresent()){
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


 */
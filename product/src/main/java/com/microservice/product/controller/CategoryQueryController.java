package com.microservice.product.controller;

import com.microservice.product.entity.Category;
import com.microservice.product.service.query.CategoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryQueryController {
    @Autowired
    private CategoryQueryService categoryQueryService;

    @GetMapping("/all")
    public List<Category> allCategory(){
        return categoryQueryService.allCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> categoryIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Category> categoryOptional = categoryQueryService.byId(id);
        if (categoryOptional.isPresent()){
            return ResponseEntity.ok(categoryOptional.get());
        }
        return ResponseEntity.notFound().build();
    }


}

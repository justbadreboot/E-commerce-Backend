package com.microservice.product.controller;


import com.microservice.product.entity.Product;
import com.microservice.product.mapper.ProductMapper;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.repository.ProductRepository;
import com.microservice.product.service.command.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Tag(name = "Product Query")
@RequestMapping("/api/public/product")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductQueryController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Operation(summary = "Obtener todos los productos")
    @GetMapping("/all")
    public List<Product> allProducts(){
        log.info("Retorna los productos");
        return productService.findAllProducts();
    }

    @Operation(summary = "Obtener información de producto por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> productIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Product> productOptional = productService.byId(id);
        if (productOptional.isPresent()){
            log.info("Producto obtenido");
            return ResponseEntity.ok(productOptional.get());
        }
        log.warn("No existen coincidencias");
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Filtrar producto por nombre")
    @GetMapping("/filter/{name}")
    public ResponseEntity<?> listProductsByName(@PathVariable(value = "name") String name){
        List<Product> productOptional = productRepository.findByNameContains(name);
        if (productOptional.isEmpty()){
            log.warn("No existen coincidencias");
            return ResponseEntity.ok("No existen coincidencias");
        }
        log.info("Productos Obtenidos");
        return ResponseEntity.ok(productOptional);
    }

    @Operation(summary = "Obtener producto por ID de categoría")
    @GetMapping("/category/{id}")
    public ResponseEntity<?> productsByCategory(@PathVariable(value = "id") Integer id){
        List<Product> productOptional = productRepository.findByCategoryId(id);
        if (!categoryRepository.findById(id).isPresent()){
            log.warn("No existen coincidencias");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la categoría");
        }
        if (productOptional.isEmpty()){
            log.warn("No existen coincidencias");
            return ResponseEntity.ok("No existen productos asiciados a esa categoria");
        }
        log.info("Obtener categoria");
        return ResponseEntity.ok(productOptional);
    }



    @Operation(summary = "Obtener productos principales 8")
    @GetMapping("/main")
    public ResponseEntity<?> productsMain(){
        List<Product> products = productRepository.mainProductLimit();
        if (products.isEmpty()){
            log.warn("No existen coincidencias");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't products");
        }
        log.info("Lista de productos");
        return ResponseEntity.ok(mapper.listEntityToDtoMains(products));
    }
    @Operation(summary = "Obtener Productos similares")
    @GetMapping("/same/category/{id}")
    public ResponseEntity<?> sameProducts(@PathVariable(value = "id") Integer id){
        List<Product> products = productRepository.productsameCategory(id);
        if (products.isEmpty()){
            log.warn("No existen coincidencias");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't same products");
        }
        log.info("Productos obtenidos");
        return ResponseEntity.ok(mapper.listEntityToDtoSame(products));
    }



}

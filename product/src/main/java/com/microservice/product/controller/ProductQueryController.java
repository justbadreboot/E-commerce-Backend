package com.microservice.product.controller;

import com.microservice.product.dto.ProductMainDTO;
import com.microservice.product.entity.Product;
import com.microservice.product.mapper.ProductMapper;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.repository.ProductRepository;
import com.microservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/public/product")
@CrossOrigin(value = "*")
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

    @GetMapping("/all")
    public List<Product> allProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> productIdInformation(@PathVariable(value = "id") Integer id){
        Optional<Product> productOptional = productService.byId(id);
        if (productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<?> listProductsByName(@PathVariable(value = "name") String name){
        List<Product> productOptional = productRepository.findByNameContains(name);
        if (productOptional.isEmpty()){
            return ResponseEntity.ok("No existen coincidencias");
        }
        return ResponseEntity.ok(productOptional);
        //productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> productsByCategory(@PathVariable(value = "id") Integer id){
        List<Product> productOptional = productRepository.findByCategoryId(id);
        if (!categoryRepository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe la categoría");
        }
        if (productOptional.isEmpty()){
            return ResponseEntity.ok("No existen productos asiciados a esa categoria");
        }
        return ResponseEntity.ok(productOptional);
    }



    @GetMapping("/main")
    public ResponseEntity<?> productsMain(){
        List<Product> products = productRepository.mainProductLimit();
        if (products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't products");
        }

        //return ResponseEntity.ok(listEntityToDtoMain(products));
        return ResponseEntity.ok(mapper.listEntityToDtoMains(products));
    }
    @GetMapping("/same/category/{id}")
    public ResponseEntity<?> sameProducts(@PathVariable(value = "id") Integer id){
        List<Product> products = productRepository.productsameCategory(id);
        if (products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't same products");
        }

        //return ResponseEntity.ok(listEntityToDtoMain(products));
        return ResponseEntity.ok(mapper.listEntityToDtoSame(products));
    }

    public ProductMainDTO mapeador(Product product){

        ProductMainDTO productMainDTO = new ProductMainDTO();

        productMainDTO.setId( product.getId() );
        productMainDTO.setName( product.getName() );
        productMainDTO.setPvp( product.getPvp() );
        productMainDTO.setImage( product.getImage() );
        productMainDTO.setRating( product.getRating() );
        productMainDTO.setStock( product.getStock() );
        return productMainDTO;
    }

    public List<ProductMainDTO> listEntityToDtoMain(List<Product> products) {

        List<ProductMainDTO> list = new ArrayList<ProductMainDTO>( products.size() );
        for ( Product product : products ) {
            list.add( mapeador( product ) );
        }

        return list;
    }

}

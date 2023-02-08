package com.microservice.product.controller;

import com.microservice.product.dto.ProductMainDTO;
import com.microservice.product.entity.Product;
import com.microservice.product.mapper.ProductMapper;
import com.microservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(value = "*")
@RequiredArgsConstructor
public class ProductQueryController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    @GetMapping("/main")
    public ResponseEntity<?> productsMain(){
        List<Product> products = productRepository.mainProductLimit();
        if (products.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't products");
        }

        //return ResponseEntity.ok(listEntityToDtoMain(products));
        return ResponseEntity.ok(mapper.listEntityToDtoMains(products));
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

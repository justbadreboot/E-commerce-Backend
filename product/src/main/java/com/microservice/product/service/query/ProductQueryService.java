package com.microservice.product.service.query;

import com.microservice.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {

    Optional<Product> findProductsByCategory(Integer id);

    List<Product> findAllProducts();
}

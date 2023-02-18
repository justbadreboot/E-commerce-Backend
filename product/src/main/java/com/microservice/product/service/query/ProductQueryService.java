package com.microservice.product.service.query;

import com.microservice.product.entity.Product;

import java.util.List;

public interface ProductQueryService {

    List<Product> findProductsByCategory(Integer id);

    List<Product> findAllProducts();
}

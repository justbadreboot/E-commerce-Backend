package com.microservice.product.repository;

import com.microservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCategoryId(Integer id);

    Optional<Product> findByPromotionId(Integer id);

    Optional<Product> findByNameContains(String name);

}

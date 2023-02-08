package com.microservice.product.repository;

import com.microservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByCategoryId(Integer id);

    Optional<Product> findByPromotionId(Integer id);

    Optional<Product> findByNameContains(String name);


    @Query(value="select * from product a WHERE a.stock > 0 order by  RAND() LIMIT 0,8 ", nativeQuery=true)
    List<Product> mainProductLimit ();

}

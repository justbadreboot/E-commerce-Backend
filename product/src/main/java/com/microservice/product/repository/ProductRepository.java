package com.microservice.product.repository;

import com.microservice.product.dto.OrderDetailDTO;
import com.microservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategoryId(Integer id);

    Optional<Product> findByPromotionId(Integer id);

    List<Product> findByNameContains(String name);


    @Query(value="select * from product a WHERE a.stock > 0 order by  RAND() LIMIT 0,8 ", nativeQuery=true)
    List<Product> mainProductLimit ();

    @Query(value="select * from product a WHERE a.category_id = :value order by  RAND() LIMIT 0,4 ", nativeQuery=true)
    List<Product> productsameCategory (Integer value);

    //@Query(value = )
    //OrderDetailDTO findByName

}

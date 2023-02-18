package com.microservice.product.service.command;

import com.microservice.product.dto.OrderDetailDTO;
import com.microservice.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findProductsByCategory(Integer id);

    List<Product> findAllProducts();

    Product saveProduct(Product product);

    Optional<Product> byId(Integer id);


    void deletePoduct(Integer id);

    void updateStock(List<OrderDetailDTO> orderDetailDTO);

    void updateStockPlus(List<OrderDetailDTO> orderDetailDTOS);




}

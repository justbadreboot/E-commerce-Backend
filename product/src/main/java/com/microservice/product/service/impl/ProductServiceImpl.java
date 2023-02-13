package com.microservice.product.service.impl;

import com.microservice.product.dto.OrderDetailDTO;
import com.microservice.product.entity.Product;
import com.microservice.product.repository.ProductRepository;
import com.microservice.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductsByCategory(Integer id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> byId(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void deletePoduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateStock(List<OrderDetailDTO> orderDetailDTO) {
        for (OrderDetailDTO detailDTO : orderDetailDTO) {
            productRepository.updateStock(detailDTO.getName(), detailDTO.getAmount());
        }
    }

    @Transactional
    @Override
    public void updateStockPlus(List<OrderDetailDTO> orderDetailDTOS) {
        for (OrderDetailDTO detailDTO : orderDetailDTOS) {
            productRepository.updateStockPlus(detailDTO.getName(), detailDTO.getAmount());
        }
    }
}

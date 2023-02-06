package com.microservice.product.service.query.impl;

import com.microservice.product.entity.Category;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.service.query.CategoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements CategoryQueryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Category> byId(Integer id) {
        return categoryRepository.findById(id);
    }
}

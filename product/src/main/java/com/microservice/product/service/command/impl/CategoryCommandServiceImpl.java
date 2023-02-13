package com.microservice.product.service.command.impl;

import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;
import com.microservice.product.mapper.CategoryMapper;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.service.command.CategoryCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
@Service
public class CategoryCommandServiceImpl implements CategoryCommandService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void saveCategory(CategoryPostDTO categoryPostDTO) {
        categoryRepository.save(categoryMapper.dtoPostCategoryToCategory(categoryPostDTO));
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category, CategoryPostDTO categoryPostDTO) {
        category.setName(categoryPostDTO.getName());
        category.setDescription(categoryPostDTO.getDescription());
        category.setImage(categoryPostDTO.getImage());
    }
}

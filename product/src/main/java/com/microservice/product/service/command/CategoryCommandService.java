package com.microservice.product.service.command;

import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;

public interface CategoryCommandService {

    void saveCategory(CategoryPostDTO categoryPostDTO);

    void deleteCategory(Integer id);

    void updateCategory(Category category, CategoryPostDTO categoryPostDTO);
}

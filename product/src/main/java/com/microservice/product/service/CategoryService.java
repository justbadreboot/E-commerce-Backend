package com.microservice.product.service;

import com.microservice.product.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> allCategory();

    Optional<Category> byId(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}

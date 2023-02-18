package com.microservice.product.service.query;

import com.microservice.product.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryService {

    List<Category> allCategory();

    Optional<Category> byId(Integer id);

}

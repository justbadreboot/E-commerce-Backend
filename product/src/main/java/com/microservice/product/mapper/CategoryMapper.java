package com.microservice.product.mapper;

import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category dtoPostCategoryToCategory (CategoryPostDTO categoryPostDTO);
}

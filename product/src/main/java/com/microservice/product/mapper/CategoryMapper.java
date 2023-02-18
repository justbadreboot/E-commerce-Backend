package com.microservice.product.mapper;

import com.microservice.product.dto.CategoryDto;
import com.microservice.product.dto.CategoryPostDTO;
import com.microservice.product.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    Category dtoPostCategoryToCategory (CategoryPostDTO categoryPostDTO);
    CategoryDto categgoryEntityToDTO(Category category);
    List<CategoryDto> listCategoryEntityToDTO(List<Category> category);

}

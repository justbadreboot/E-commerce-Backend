package com.microservice.product.mapper;

import com.microservice.product.dto.ProductMainDTO;
import com.microservice.product.dto.ProductPostDTO;
import com.microservice.product.dto.ProductSameCategoryDTO;
import com.microservice.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product dtoToEntityProduct (ProductPostDTO dto);

    ProductPostDTO entitytoDtoPost(Product product);
    Product stoToEntityMainProduct(ProductMainDTO dto);

    ProductMainDTO entityToDtoMain(Product product);

    List<Product> dtoListToMainListProducts(List<ProductMainDTO> dto);

    List<ProductMainDTO> listEntityToDtoMains(List<Product> product);

    ProductSameCategoryDTO entityToDtoSame(Product product);

    List<ProductSameCategoryDTO> listEntityToDtoSame(List<Product> product);

}

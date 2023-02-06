package com.microservice.product.mapper;


import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.entity.Promotion;
import org.mapstruct.Mapper;

@Mapper
public interface PromotionMapper {
    Promotion dtoPostPromotiontoPromotion(PromotionPostDTO promotionPostDTO);
}

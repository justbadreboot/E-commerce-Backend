package com.microservice.product.mapper;


import com.microservice.product.dto.PromotionNewDTO;
import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.dto.PromotionTypeDTO;
import com.microservice.product.entity.Promotion;
import com.microservice.product.entity.PromotionTypes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PromotionMapper {
    PromotionTypes dtoPromotionToPromotionType(PromotionTypeDTO promotionTypeDTO);

    Promotion dtoPostPromotiontoPromotion(PromotionPostDTO promotionPostDTO);

    @Mapping(source = "promotionTypeDTO", target = "promotionTypes")
    Promotion dtoNewPromotionToEntity(PromotionNewDTO promotionNewDTO);



}

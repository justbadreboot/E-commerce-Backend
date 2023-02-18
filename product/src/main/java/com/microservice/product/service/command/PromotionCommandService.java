package com.microservice.product.service.command;

import com.microservice.product.dto.PromotionNewDTO;
import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.entity.Promotion;

public interface PromotionCommandService {

    void savePromotion(PromotionNewDTO promotionPostDTO);

    void deletePromotion(Integer id);

    void updatePromotion(Promotion promotion, PromotionPostDTO promotionPostDTO);

    public void mapperPromotion(Promotion promotion, PromotionNewDTO promotionNewDTO);

}

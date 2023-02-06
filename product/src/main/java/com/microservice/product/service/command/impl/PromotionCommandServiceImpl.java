package com.microservice.product.service.command.impl;

import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.entity.Promotion;
import com.microservice.product.mapper.PromotionMapper;
import com.microservice.product.repository.PromotionRepository;
import com.microservice.product.service.command.PromotionCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionCommandServiceImpl implements PromotionCommandService {

    @Autowired
    private PromotionRepository promotionRepository;

    private PromotionMapper promotionMapper;



    @Override
    public void savePromotion(PromotionPostDTO promotionPostDTO) {
        promotionRepository.save(promotionMapper.dtoPostPromotiontoPromotion(promotionPostDTO));
    }

    @Override
    public void deletePromotion(Integer id) {
        promotionRepository.deleteById(id);

    }

    @Override
    public void updatePromotion(Promotion promotion, PromotionPostDTO promotionPostDTO) {
        promotion.setName(promotionPostDTO.getName());
        promotion.setDescription(promotionPostDTO.getDescription());
        promotion.setEndDate(promotionPostDTO.getEndDate());
        promotion.setDiscount(promotionPostDTO.getDiscount());
        promotion.setStartDate(promotionPostDTO.getStartDate());
    }

}

package com.microservice.product.service.command.impl;

import com.microservice.product.dto.PromotionNewDTO;
import com.microservice.product.dto.PromotionPostDTO;
import com.microservice.product.entity.Promotion;
import com.microservice.product.mapper.PromotionMapper;
import com.microservice.product.repository.PromotionRepository;
import com.microservice.product.service.command.PromotionCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PromotionCommandServiceImpl implements PromotionCommandService {

    @Autowired
    private PromotionRepository promotionRepository;

    private PromotionMapper promotionMapper;



    @Override
    public void savePromotion(PromotionNewDTO promotionPostDTO) {
        log.info("promotion {}", promotionPostDTO);
        promotionRepository.save(promotionMapper.dtoNewPromotionToEntity(promotionPostDTO));
        log.info("mapeo de promocion {}", promotionPostDTO);
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
        promotion.setImage(promotionPostDTO.getImage());
        promotion.setStartDate(promotionPostDTO.getStartDate());
    }

    @Override
    public void mapperPromotion(Promotion promotion, PromotionNewDTO promotionNewDTO){
        promotion.setName(promotionNewDTO.getName());
        promotion.setDescription(promotionNewDTO.getDescription());
        promotion.setEndDate(promotionNewDTO.getEndDate());
        promotion.setStartDate(promotionNewDTO.getStartDate());
        promotion.setImage(promotionNewDTO.getImage());
        promotion.setPromotionTypes(promotionMapper.dtoPromotionToPromotionType(promotionNewDTO.getPromotionTypeDTO()));
    }

}

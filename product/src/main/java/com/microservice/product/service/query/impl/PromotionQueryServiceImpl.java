package com.microservice.product.service.query.impl;

import com.microservice.product.entity.Promotion;
import com.microservice.product.repository.PromotionRepository;
import com.microservice.product.service.query.PromotionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionQueryServiceImpl implements PromotionQueryService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public List<Promotion> allPromotion() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> byId(Integer id) {
        return promotionRepository.findById(id);
    }
}

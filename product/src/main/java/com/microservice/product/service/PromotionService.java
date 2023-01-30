package com.microservice.product.service;

import com.microservice.product.entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {

    List<Promotion> allPromotion();

    Optional<Promotion> byId(Integer id);

    Promotion savePromotion(Promotion promotion);

    void deletePromotion(Integer id);

}

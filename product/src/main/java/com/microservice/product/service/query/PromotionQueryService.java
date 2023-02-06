package com.microservice.product.service.query;

import com.microservice.product.entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionQueryService {

    List<Promotion> allPromotion();

    Optional<Promotion> byId(Integer id);

}

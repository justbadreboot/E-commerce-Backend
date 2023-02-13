package com.microservice.product.dto;

import com.microservice.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionNewDTO {
    private String name;
    private String description;
    private String image;
    private Date startDate;
    private Date endDate;

    private Product product;

    private PromotionTypeDTO promotionTypeDTO;
}

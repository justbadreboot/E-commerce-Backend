package com.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionPostDTO {

    private String name;
    private String description;
    private Integer discount;
    private Date startDate;
    private Date endDate;
}

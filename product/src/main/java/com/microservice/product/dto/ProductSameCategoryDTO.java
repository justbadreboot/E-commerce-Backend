package com.microservice.product.dto;

import lombok.Data;

@Data
public class ProductSameCategoryDTO {
    private Integer id;
    private String name;
    private Double pvp;
    private String image;
    private String brand;
    private Double rating;
    private Integer stock;
}

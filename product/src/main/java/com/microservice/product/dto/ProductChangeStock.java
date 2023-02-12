package com.microservice.product.dto;

import lombok.Data;

@Data
public class ProductChangeStock {
    private String name;
    private Integer stock;
}

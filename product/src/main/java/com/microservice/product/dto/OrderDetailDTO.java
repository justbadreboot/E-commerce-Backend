package com.microservice.product.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    private Integer orderId;
}

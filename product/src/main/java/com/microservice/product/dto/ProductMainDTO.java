package com.microservice.product.dto;

import lombok.*;

@Data
public class ProductMainDTO {


    private Integer id;
    private String name;
    private Double pvp;
    private String image;
    private Double rating;
    private Integer stock;
    private Integer porcentajeDescuento;

}

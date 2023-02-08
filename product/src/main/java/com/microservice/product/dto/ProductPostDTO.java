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
public class ProductPostDTO {

    private String name;
    private String description;
    private Integer stock;
    private Double pvp;
    private Double pvd;
    private String image;
    private String brand;
    private Double weight;
    private Double size;
    private Integer porcentajeDescuento;
    private Date expiration;
    private Double rating;
}

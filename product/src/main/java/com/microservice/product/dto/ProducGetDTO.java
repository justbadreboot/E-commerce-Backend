package com.microservice.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProducGetDTO {
    private Integer id;
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
}

package com.microservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicePostDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private String image;
}

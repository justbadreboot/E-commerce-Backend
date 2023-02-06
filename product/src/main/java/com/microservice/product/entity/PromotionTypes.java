package com.microservice.product.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PromotionTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}

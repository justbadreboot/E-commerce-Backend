package com.microservice.product.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;
}

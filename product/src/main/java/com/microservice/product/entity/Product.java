package com.microservice.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(unique = true)
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

    //@ManyToOne(fetch = FetchType.LAZY, optional = true)
    //@JoinColumn(name = "promotion_id", nullable = true, insertable = false)
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //private Promotion promotion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

}

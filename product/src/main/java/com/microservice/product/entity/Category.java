package com.microservice.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Data
public class Category extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;
}

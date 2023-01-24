package com.microservice.landing.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Landing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private String address;

    private String mission;

    private String vision;

    private String phone;




}

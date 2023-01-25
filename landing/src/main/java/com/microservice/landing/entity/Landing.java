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

    @Lob
    private String description;

    @Lob
    private String address;

    @Lob
    private String mission;

    @Lob
    private String vision;

    private String phone;


}

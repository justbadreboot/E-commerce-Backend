package com.microservice.service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Especialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}

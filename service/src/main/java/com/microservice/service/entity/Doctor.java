package com.microservice.service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String phone;
    private String email;
    private String address;
}

package com.microservice.authserve.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class AuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String email;

    private String password;

    private String role;
}

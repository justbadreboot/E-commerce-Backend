package com.microservice.landing.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    @Email
    private String email;


}

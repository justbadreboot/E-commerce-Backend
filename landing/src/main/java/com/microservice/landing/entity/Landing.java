package com.microservice.landing.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Table
@Entity
@Data
public class Landing extends Auditable<String> implements Serializable {
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

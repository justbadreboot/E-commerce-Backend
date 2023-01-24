package com.microservice.client.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String document;

    private String phone;

}
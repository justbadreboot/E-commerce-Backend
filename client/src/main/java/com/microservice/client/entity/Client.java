package com.microservice.client.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @Size(max = 13)
    private String document;
    private String phone;
}
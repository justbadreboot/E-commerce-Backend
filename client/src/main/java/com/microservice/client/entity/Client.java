package com.microservice.client.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table
@Data
public class Client extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clientId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    @Size(max = 13)
    private String document;
    private String phone;
}
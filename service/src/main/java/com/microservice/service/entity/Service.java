package com.microservice.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String price;
    @OneToOne
    @JoinColumn(name = "specialty_id")
    @JsonIgnore
    private Specialty specialty;

}

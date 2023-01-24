package com.microservice.client.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private Integer state;
    private String sector;
    private String postalCode;
    private String mainStreet;
    private String secondStreet;
    private String houseNumber;
}
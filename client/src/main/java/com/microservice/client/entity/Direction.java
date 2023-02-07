package com.microservice.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String state;
    private String sector;
    private String postalCode;
    private String mainStreet;
    private String secondStreet;
    private String houseNumber;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "id_client", nullable = false)
    @JsonIgnore
    private Client client;
}
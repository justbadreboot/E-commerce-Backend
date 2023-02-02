package com.microservice.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clientId;
    private Integer serviceId;
    private LocalDateTime date;
    private Double price;
    private String duration;
    private String reason;


}

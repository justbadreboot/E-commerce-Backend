package com.microservice.invoice.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table
public class Correlative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sequence;
}

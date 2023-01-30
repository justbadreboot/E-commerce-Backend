package com.microservice.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class PaymentState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String state;

}

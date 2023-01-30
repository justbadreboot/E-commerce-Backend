package com.microservice.order.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetails {

    @Id
    private Integer id;

    private String name;

    private Integer amount;

    private Double price;


}

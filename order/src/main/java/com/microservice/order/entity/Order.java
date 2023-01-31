package com.microservice.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "krugorders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private Double total;

    private Double subtotal;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deliveryState_id", nullable = false)
    private DeliveryState deliveryState;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderState_id", nullable = false)
    //@JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "paymentState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PaymentState paymentState;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails = new ArrayList<>();

}

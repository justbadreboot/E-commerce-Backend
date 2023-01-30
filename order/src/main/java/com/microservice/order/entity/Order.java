package com.microservice.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Double total;

    private Double subtotal;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deliveryState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DeliveryState deliveryState;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paymentState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PaymentState paymentState;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderDetails_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<OrderDetails> orderDetails = new HashSet<>();

}

package com.microservice.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "krugorders")
@Data
public class Order extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private Date date;

    @NotBlank
    private Double total;
    @NotBlank
    private Double subtotal;
    @NotBlank
    private Integer idClient;
    @NotBlank
    private Integer idAddress;

    private String clientDocument;
    private String clientName;
    private String clientLastName;
    private String clientPhone;



    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "deliveryState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DeliveryState deliveryState;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "orderState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "paymentState_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PaymentState paymentState;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails = new ArrayList<>();

}

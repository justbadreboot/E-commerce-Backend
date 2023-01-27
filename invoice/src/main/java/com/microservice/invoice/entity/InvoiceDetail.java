package com.microservice.invoice.entity;

import com.microservice.invoice.InvoiceApplication;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Invoice invoice;
    private String productName;
    private String productDescription;
    private Integer quantity;
    private Double price;
    private Double discount;
    private Double total;
}

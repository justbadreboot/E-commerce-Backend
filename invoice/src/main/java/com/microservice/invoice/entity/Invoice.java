package com.microservice.invoice.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Invoice extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private LocalDate date;
    private Double subtotal;
    private Double total;
    private Integer clientId;
    private Integer customerAddress;
    private String customerName;
    private String customerLastName;
    private String customerPhone;
    private String customerDocument;
    private String orderState;
    private String paymentState;
    private String deliveryState;

    @OneToMany(mappedBy = "invoiceId",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details = new ArrayList<>();

}

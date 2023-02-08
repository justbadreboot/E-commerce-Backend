package com.microservice.invoice.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private LocalDateTime date;
    private Double subtotal;
    private Double total;
    private String clientName;
    private String clientLastName;
    private String clientPhone;
    private String clientDocument;
    @OneToMany(mappedBy = "invoiceId",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details = new ArrayList<>();

}

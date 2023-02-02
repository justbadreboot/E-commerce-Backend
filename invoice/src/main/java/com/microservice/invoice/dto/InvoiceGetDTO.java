package com.microservice.invoice.dto;

import com.microservice.invoice.entity.InvoiceDetail;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceGetDTO {
    private Integer id;
    private Integer number;
    private LocalDateTime date;
    private Double subtotal;
    private Double total;
    private String clientName;
    private String clientLastName;
    private String clientPhone;
    private String clientDocument;
    private List<InvoiceDetail> details = new ArrayList<>();
}

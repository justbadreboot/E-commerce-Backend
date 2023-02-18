package com.microservice.invoice.dto;

import com.microservice.invoice.entity.InvoiceDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceGetDTO {
    private Integer id;
    private String number;
    private LocalDate date;
    private Double subtotal;
    private Double total;
    private Integer clientId;
    private String customerName;
    private String customerLastName;
    private String customerPhone;
    private String customerDocument;
    private String orderState;
    private String paymentState;
    private String deliveryState;
    private List<InvoiceDetailGetDTO> details;
}

package com.microservice.invoice.dto;

import com.microservice.invoice.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDetailPostDTO {
    private Invoice invoice;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double total;
}

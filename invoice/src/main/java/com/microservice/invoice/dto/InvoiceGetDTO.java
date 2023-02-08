package com.microservice.invoice.dto;

import com.microservice.invoice.entity.InvoiceDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceGetDTO {
    private Integer id;
    private Integer number;
    private LocalDateTime date;
    private Double subtotal;
    private Double total;
    private Integer clientId;
    private String clientName;
    private String clientLastName;
    private String clientPhone;
    private String clientDocument;
    private List<InvoiceDetailGetDTO> details;
}

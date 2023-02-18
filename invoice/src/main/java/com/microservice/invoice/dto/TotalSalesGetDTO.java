package com.microservice.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalSalesGetDTO {
    private Double today;
    private Double month;
    private Integer countTodayInvoice;
}

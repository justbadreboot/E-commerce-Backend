package com.microservice.invoice.dto.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailPostDTO {
    private Integer id;
    private String name;
    private Integer amount;
    private Double price;
    private Integer orderId;
}

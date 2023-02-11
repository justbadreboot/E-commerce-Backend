package com.microservice.invoice.dto.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailPostDTO {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Integer amount;
    @NotNull
    private Double price;
    private Integer orderId;
}

package com.microservice.invoice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPostDTO {
    private Integer id;
    private LocalDate date;
    private Double total;
    private Double subtotal;
    private Integer idClient;
    private Integer idAddress;
    private String address;
    private StatePostDTO orderState;
    private StatePostDTO paymentState;
    private StatePostDTO deliveryState;
    private List<OrderDetailPostDTO> orderDetails;

}

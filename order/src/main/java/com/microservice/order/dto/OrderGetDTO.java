package com.microservice.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderGetDTO {

    private Integer id;
    @NotBlank
    private Date date;
    @NotBlank
    private Double total;
    @NotBlank
    private Double subtotal;
    @NotBlank
    private Integer idClient;
    @NotBlank
    private Integer idAddress;

    private String clientDocument;
    private String clientName;
    private String clientLastName;
    private String clientPhone;

    private PaymentStateDTO paymentState;

    private DeliveryStateDTO deliveryState;

    private OrderStateDTO orderState;

    private List<OrderDetailsDTO> orderDetails =new ArrayList<>();

}

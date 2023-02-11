package com.microservice.invoice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPostDTO {
    private Integer id;
    private LocalDate date;
    @NotNull
    private Double total;
    @NotNull
    private Double subtotal;
    @NotNull
    private Integer idClient;
    @NotNull
    private Integer idAddress;
    @NotBlank
    private String address;
    @NotBlank
    private String clientDocument;
    @NotBlank
    private String clientLastName;
    @NotBlank
    private String clientName;
    @NotBlank
    private String clientPhone;
    private StatePostDTO orderState;
    private StatePostDTO paymentState;
    private StatePostDTO deliveryState;
    private List<OrderDetailPostDTO> orderDetails;

}

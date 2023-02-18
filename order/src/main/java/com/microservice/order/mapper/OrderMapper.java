package com.microservice.order.mapper;

import com.microservice.order.dto.*;
import com.microservice.order.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    DeliveryStateDTO deliveryEntityToDTO (DeliveryState deliveryState);
    OrderStateDTO stateEntityToDTO (OrderState orderState);
    PaymentStateDTO paymentEntityToDTO (PaymentState paymentState);
    OrderDetailsDTO detailsEntityToDTO (OrderDetails orderDetails);

    List<OrderDetailsDTO> listDetailsEntityToDTO (List<OrderDetails> orderDetails);

    OrderGetDTO orderEntityToDTO (Order order);

    List<OrderGetDTO> listOrderEntityToDTO (List<Order> order);



}

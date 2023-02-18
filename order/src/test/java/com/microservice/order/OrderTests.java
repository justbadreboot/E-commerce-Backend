package com.microservice.order;
import com.microservice.order.entity.DeliveryState;
import com.microservice.order.entity.OrderState;
import com.microservice.order.entity.PaymentState;
import com.microservice.order.repository.DeliveryStateRepository;
import com.microservice.order.repository.OrderStateRepository;
import com.microservice.order.repository.PaymentStateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderTests {
    @InjectMocks
    private PaymentState paymentState;
    @InjectMocks
    private OrderState orderState;
    @InjectMocks
    private DeliveryState deliveryState;

    @Mock
    private PaymentStateRepository paymentStateRepository;
    @Mock
    private OrderStateRepository orderStateRepository;
    @Mock
    private DeliveryStateRepository deliveryStateRepository;

    @Test
    void verPaymentState(){
        when(paymentStateRepository.findAll()).thenReturn(Arrays.asList(paymentState));
        assertNotNull(paymentStateRepository.findAll());
    }

    @Test
    void verOrderState(){
        when(orderStateRepository.findAll()).thenReturn(Arrays.asList(orderState));
        assertNotNull(orderStateRepository.findAll());
    }
    @Test
    void verDeliveryState(){
        when(deliveryStateRepository.findAll()).thenReturn(Arrays.asList(deliveryState));
        assertNotNull(deliveryStateRepository.findAll());
    }

}

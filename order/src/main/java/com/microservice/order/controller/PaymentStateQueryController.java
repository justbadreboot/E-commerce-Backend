package com.microservice.order.controller;

import com.microservice.order.entity.PaymentState;
import com.microservice.order.repository.PaymentStateRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Payment State Query")
@RestController
@RequestMapping("/api/repartidor/state")
@CrossOrigin(value = "*")
public class PaymentStateQueryController {
    @Autowired
    private PaymentStateRepository paymentStateRepository;

    @Operation(summary = "Obtener todas las ordenes por estado de Pago")
    @GetMapping("/payment/all")
    public List<PaymentState> allPaymentState(){
        return paymentStateRepository.findAll();
    }
}

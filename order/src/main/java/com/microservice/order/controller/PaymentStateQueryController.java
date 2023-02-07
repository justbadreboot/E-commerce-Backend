package com.microservice.order.controller;

import com.microservice.order.entity.PaymentState;
import com.microservice.order.repository.PaymentStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/state")
@CrossOrigin(value = "*")
public class PaymentStateQueryController {
    @Autowired
    private PaymentStateRepository paymentStateRepository;

    @GetMapping("/payment/all")
    public List<PaymentState> allPaymentState(){
        return paymentStateRepository.findAll();
    }
}

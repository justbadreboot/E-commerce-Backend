package com.microservice.order.controller;

import com.microservice.order.entity.OrderState;
import com.microservice.order.repository.OrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repartidor/state")
@CrossOrigin(value = "*")
public class OrderStateQueryController {
    @Autowired
    private OrderStateRepository orderStateRepository;

    @GetMapping("/order/all")
    public List<OrderState> allOrderState(){
        return orderStateRepository.findAll();
    }
}

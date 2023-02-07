package com.microservice.order.controller;

import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/command")
@CrossOrigin(value = "*")
public class OrderCommandController {
    @Autowired
    private OrderService orderService;
}

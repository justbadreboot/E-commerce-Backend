package com.microservice.order.controller;

import com.microservice.order.entity.OrderState;
import com.microservice.order.repository.OrderStateRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Order State Query")
@RestController
@RequestMapping("/api/repartidor/state")
@CrossOrigin(value = "*")
@Slf4j
public class OrderStateQueryController {
    @Autowired
    private OrderStateRepository orderStateRepository;

    @Operation(summary = "Obtener todas las estads de una orden")
    @GetMapping("/order/all")
    public List<OrderState> allOrderState(){
        log.info("Informacion obtenida de estados de orden");
        return orderStateRepository.findAll();
    }
}

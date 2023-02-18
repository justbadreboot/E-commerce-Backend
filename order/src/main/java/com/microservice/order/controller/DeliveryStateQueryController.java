package com.microservice.order.controller;

import com.microservice.order.entity.DeliveryState;
import com.microservice.order.repository.DeliveryStateRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Delivery State Query")
@RestController
@RequestMapping("/api/repartidor/state")
@CrossOrigin(value = "*")
public class DeliveryStateQueryController {

    @Autowired
    private DeliveryStateRepository deliveryStateRepository;

    @Operation(summary = "Obtener todos los estados de delivery")
    @GetMapping("/delivery/all")
    public List<DeliveryState> allDelivery(){
        return deliveryStateRepository.findAll();
    }

}

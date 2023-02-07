package com.microservice.order.controller;

import com.microservice.order.entity.DeliveryState;
import com.microservice.order.entity.Order;
import com.microservice.order.repository.DeliveryStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/state")
@CrossOrigin(value = "*")
public class DeliveryStateQueryController {

    @Autowired
    private DeliveryStateRepository deliveryStateRepository;

    @GetMapping("/delivery/all")
    public List<DeliveryState> allDelivery(){
        return deliveryStateRepository.findAll();
    }

}

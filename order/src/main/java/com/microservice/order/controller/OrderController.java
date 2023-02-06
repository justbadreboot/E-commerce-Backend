package com.microservice.order.controller;

import com.microservice.order.entity.Order;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(value = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/all")
    public List<Order> allOrders(){
        return orderService.findallOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOrderById(@RequestParam(value = "id") Integer id){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            return ResponseEntity.ok(orderOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?>addOrders(@Valid @RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrders(order));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrders(@RequestParam(value = "id") Integer id){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>editStatesForOrders(@RequestParam(value = "id") Integer id, @RequestBody Order order){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            Order orderBD = orderOptional.get();
            orderBD.setDate(order.getDate());
            orderBD.setSubtotal(order.getSubtotal());
            orderBD.setTotal(order.getTotal());
            orderBD.setIdClient(order.getIdClient());
            orderBD.setDeliveryState(order.getDeliveryState());
            orderBD.setPaymentState(order.getPaymentState());
            orderBD.setOrderState(order.getOrderState());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.saveOrders(orderBD));
        }
        return ResponseEntity.notFound().build();
    }
}

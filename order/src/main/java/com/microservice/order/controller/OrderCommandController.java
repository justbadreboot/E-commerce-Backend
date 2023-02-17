package com.microservice.order.controller;

import com.microservice.order.entity.Order;
import com.microservice.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class OrderCommandController {
    @Autowired
    private OrderService orderService;

    private Integer val = 0;

    @PostMapping("/cliente/order")
    public ResponseEntity<?>addOrders(@Valid @RequestBody Order order){
        if (order.getIdAddress().equals(val)){
            log.info("Validacion order cero");
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe asignar un Id diferente de 0 a dirección");
        }
        log.warn("Datos de orden guardados {}", order);
        log.info("oaaaaaaaaaaaaaaaaaaaaa");
        log.error("eaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        log.info("address {}",order.getIdAddress());
        log.warn("Datos id de Address {}",order.getIdAddress());

        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrders(order));
    }
   /* @DeleteMapping("/private/order/{id}")
    public ResponseEntity<?> deleteOrders(@PathVariable(value = "id") Integer id){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    */

    @PutMapping("/cliente/order/{id}")
    public ResponseEntity<?>editStatesForOrders(@PathVariable(value = "id") Integer id, @RequestBody Order order){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            Order orderBD = orderOptional.get();
            orderBD.setDate(order.getDate());
            orderBD.setSubtotal(order.getSubtotal());
            orderBD.setTotal(order.getTotal());
            orderBD.setIdClient(order.getIdClient());
            orderBD.setIdAddress(order.getIdAddress());
            orderBD.setClientDocument(order.getClientDocument());
            orderBD.setClientName(order.getClientName());
            orderBD.setClientLastName(order.getClientLastName());
            orderBD.setClientPhone(order.getClientPhone());
            orderBD.setDeliveryState(order.getDeliveryState());
            orderBD.setPaymentState(order.getPaymentState());
            orderBD.setOrderState(order.getOrderState());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.saveOrders(orderBD));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/repartidor/order/{id}")
    public ResponseEntity<?>editStatesForOrdersRep(@PathVariable(value = "id") Integer id, @RequestBody Order order){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            Order orderBD = orderOptional.get();
            orderBD.setDate(order.getDate());
            orderBD.setSubtotal(order.getSubtotal());
            orderBD.setTotal(order.getTotal());
            orderBD.setIdClient(order.getIdClient());
            orderBD.setIdAddress(order.getIdAddress());
            orderBD.setClientDocument(order.getClientDocument());
            orderBD.setClientName(order.getClientName());
            orderBD.setClientLastName(order.getClientLastName());
            orderBD.setClientPhone(order.getClientPhone());
            orderBD.setDeliveryState(order.getDeliveryState());
            orderBD.setPaymentState(order.getPaymentState());
            orderBD.setOrderState(order.getOrderState());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.saveOrders(orderBD));
        }
        return ResponseEntity.notFound().build();
    }
}

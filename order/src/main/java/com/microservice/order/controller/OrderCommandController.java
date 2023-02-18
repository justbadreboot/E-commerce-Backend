package com.microservice.order.controller;

import com.microservice.order.entity.Order;
import com.microservice.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Tag(name = "Order Command")
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class OrderCommandController {
    @Autowired
    private OrderService orderService;

    private Integer val = 0;

    @Operation(summary = "Guardar orden, ignore campos de audit")
    @PostMapping("/cliente/order")
    public ResponseEntity<?>addOrders(@Valid @RequestBody Order order){
        if (order.getIdAddress().equals(val)){
            log.info("Validacion order cero");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe asignar un Id diferente de 0 a dirección");
        }
        log.info("Orden guardada");
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrders(order));
    }


    @Operation(summary = "Editar la orden por ID")
    @PutMapping("/cliente/order/{id}")
    public ResponseEntity<?>editStatesForOrders(@PathVariable(value = "id") Integer id, @RequestBody Order order){
        return getResponseEntity(id, order);
    }


    @Operation(summary = "Editar la order por ID repartidor")
    @PutMapping("/repartidor/order/{id}")
    public ResponseEntity<?>editStatesForOrdersRep(@PathVariable(value = "id") Integer id, @RequestBody Order order){
        return getResponseEntity(id, order);
    }
    private ResponseEntity<?> getResponseEntity(@PathVariable("id") Integer id, @RequestBody Order order) {
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
            log.info("orden editada");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.saveOrders(orderBD));
        }
        log.error("error al actualizar");
        return ResponseEntity.notFound().build();
    }
}

package com.microservice.order.controller;

import com.microservice.order.dto.SalesDTO;
import com.microservice.order.entity.Order;
import com.microservice.order.mapper.OrderMapper;
import com.microservice.order.repository.OrderRepository;
import com.microservice.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Order Query")
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class OrderQueryController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper mapper;


    @Operation(summary = "Obtener todas las ordenes")
    @GetMapping("/admin/order/all")
    public List<?> allOrders(){
        return mapper.listOrderEntityToDTO(orderService.findallOrders());
    }

    @Operation(summary = "Obtener ordenes por ID")
    @GetMapping("/cliente/order/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable(value = "id") Integer id){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            return ResponseEntity.ok(mapper.orderEntityToDTO(orderOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }



    @Operation(summary = "Obtener todos las ordenes por el estado de ID")
    @GetMapping("/repartidor/order/state/{id}")
    public ResponseEntity<?> getOrderByOrderState(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional = orderRepository.findByOrderStateId(id);
            return ResponseEntity.ok(mapper.listOrderEntityToDTO(orderOptional));

    }

    @Operation(summary = "Obtener todas las ordenes por estado de Delivery ID")
    @GetMapping("/repartidor/order/delivery/{id}")
    public ResponseEntity<?> getDeliveryByStateId(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional= orderRepository.findByDeliveryStateId(id);
            return ResponseEntity.ok(mapper.listOrderEntityToDTO(orderOptional));
    }

    @Operation(summary = "Obtener todas las ordenes por Cliente ID")
    @GetMapping("/cliente/order/client/{id}")
    public ResponseEntity<?> getOrderByClient(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional = orderRepository.findByIdClient(id);
        if (orderOptional.isEmpty()){
            return ResponseEntity.ok().body("null");
        }
        return ResponseEntity.ok(mapper.listOrderEntityToDTO(orderOptional));
    }

    @Operation(summary = "Obtener el numero de ordenes totales del día")
    @GetMapping("/admin/order/sales/allday")
    public ResponseEntity<SalesDTO> getSalesOnDay(){
        SalesDTO salesDTO = new SalesDTO();
        Integer sales = orderRepository.productsSoldOnDay();
        salesDTO.setProductsSold(sales);
        if (sales==null){
            salesDTO.setProductsSold(0);
            return ResponseEntity.ok(salesDTO);
        }
        return ResponseEntity.ok(salesDTO);
    }
}

package com.microservice.order.controller;

import com.microservice.order.dto.SalesDTO;
import com.microservice.order.entity.Order;
import com.microservice.order.repository.OrderRepository;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class OrderQueryController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;



    @GetMapping("/admin/order/all")
    public List<Order> allOrders(){
        return orderService.findallOrders();
    }

    @GetMapping("/cliente/order/{id}")
    public ResponseEntity<?> findOrderById(@PathVariable(value = "id") Integer id){
        Optional<Order> orderOptional = orderService.byId(id);
        if (orderOptional.isPresent()){
            return ResponseEntity.ok(orderOptional.get());
        }
        return ResponseEntity.notFound().build();
    }



    @GetMapping("/repartidor/order/state/{id}")
    public ResponseEntity<?> getOrderByOrderState(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional = orderRepository.findByOrderStateId(id);
       // if (orderOptional.isPresent()){
            return ResponseEntity.ok(orderOptional);
       // }
       // return ResponseEntity.notFound().build();
    }

    @GetMapping("/repartidor/order/delivery/{id}")
    public ResponseEntity<?> getDeliveryByStateId(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional= orderRepository.findByDeliveryStateId(id);
        //if (orderOptional.isPresent()){
            return ResponseEntity.ok(orderOptional);
       // }
     //   return ResponseEntity.notFound().build();
    }

    @GetMapping("/cliente/order/client/{id}")
    public ResponseEntity<?> getOrderByClient(@PathVariable(value = "id") Integer id){
        List<Order> orderOptional = orderRepository.findByIdClient(id);
      //  if (orderOptional.isPresent()){
            return ResponseEntity.ok(orderOptional);
       // }
        //return ResponseEntity.notFound().build();
    }

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

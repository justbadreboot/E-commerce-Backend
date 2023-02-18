package com.microservice.order.service;

import com.microservice.order.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findallOrders();

    Optional<Order> byId(Integer id);

    void deleteOrder(Integer id);


    Order saveOrders(Order order);


}

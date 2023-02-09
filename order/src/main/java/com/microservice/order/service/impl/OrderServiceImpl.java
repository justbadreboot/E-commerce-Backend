package com.microservice.order.service.impl;

import com.microservice.order.entity.Order;
import com.microservice.order.entity.OrderDetails;
import com.microservice.order.repository.OrderDetailsRepository;
import com.microservice.order.repository.OrderRepository;
import com.microservice.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<Order> findallOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> byId(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order saveOrders(Order order) {
        List<OrderDetails> orderDetails = order.getOrderDetails();
        Order neworder= order;
        neworder.setOrderDetails(null);
        orderRepository.save(neworder);
        for (OrderDetails detail : orderDetails){
            detail.setOrderId(neworder.getId());
        }
        neworder.setOrderDetails(orderDetailsRepository.saveAll(orderDetails));
        return neworder;
    }
}

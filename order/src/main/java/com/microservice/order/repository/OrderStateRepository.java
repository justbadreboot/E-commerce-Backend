package com.microservice.order.repository;

import com.microservice.order.entity.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStateRepository extends JpaRepository<OrderState, Integer> {
}

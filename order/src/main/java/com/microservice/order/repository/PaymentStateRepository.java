package com.microservice.order.repository;

import com.microservice.order.entity.PaymentState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentStateRepository extends JpaRepository<PaymentState, Integer> {
}

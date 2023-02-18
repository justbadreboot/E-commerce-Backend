package com.microservice.order.repository;

import com.microservice.order.entity.DeliveryState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryStateRepository extends JpaRepository<DeliveryState, Integer> {
}

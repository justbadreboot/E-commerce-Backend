package com.microservice.client.repository;

import com.microservice.client.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction, Integer> {
}

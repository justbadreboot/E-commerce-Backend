package com.microservice.client.repository;

import com.microservice.client.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Integer> {
    List<Direction> findByClientId(Integer id);
    Direction findFirstByClientId(Integer id);
}

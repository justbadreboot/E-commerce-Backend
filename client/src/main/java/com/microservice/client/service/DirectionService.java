package com.microservice.client.service;

import com.microservice.client.entity.Direction;

import java.util.List;

public interface DirectionService {
    List<Direction> findAll();
    Direction findById(Integer id);
    Direction save(Direction direction);
    void delete(Integer id);
    List<Direction> findByClientId(Integer id);
}

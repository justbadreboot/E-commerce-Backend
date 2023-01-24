package com.microservice.client.service;

import com.microservice.client.entity.Direction;
import com.microservice.client.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService{

    @Autowired
    private DirectionRepository repository;

    @Override
    public List<Direction> findAll() {
        return repository.findAll();
    }

    @Override
    public Direction findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Direction save(Direction direction) {
        return repository.save(direction);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}

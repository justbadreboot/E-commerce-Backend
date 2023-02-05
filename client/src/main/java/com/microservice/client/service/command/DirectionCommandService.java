package com.microservice.client.service.command;

import com.microservice.client.dto.DirectionPostDTO;
import com.microservice.client.entity.Direction;

import java.util.List;

public interface DirectionCommandService {
    Direction save(DirectionPostDTO directionPostDTO);
    void delete(Integer id);
}

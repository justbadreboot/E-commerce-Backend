package com.microservice.client.service.query;

import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.entity.Direction;

import java.util.List;

public interface DirectionQueryService {
    DirectionGetDTO findById(Integer id);
    List<DirectionGetDTO> findByClientId(Integer id);
}

package com.microservice.client.service.query;

import com.microservice.client.dto.DirectionCustomGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.entity.Direction;

import java.util.List;
import java.util.Map;

public interface DirectionQueryService {
    DirectionGetDTO findById(Integer id);
    DirectionGetDTO findFirstByClientId(Integer id);
    List<DirectionGetDTO> findByClientId(Integer id);
    List<DirectionCustomGetDTO> findByClientIdCustom(Integer id);
}

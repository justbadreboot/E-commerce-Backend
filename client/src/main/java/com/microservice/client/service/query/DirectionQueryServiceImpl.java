package com.microservice.client.service.query;

import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.entity.Direction;
import com.microservice.client.mapper.DirectionMapper;
import com.microservice.client.repository.DirectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectionQueryServiceImpl implements DirectionQueryService {

    @Autowired
    private DirectionRepository repository;

    private DirectionMapper mapper;
    @Override
    public DirectionGetDTO findById(Integer id) {
        Optional<Direction> direction = repository.findById(id);
        if(direction.isPresent()){
            return mapper.directionToDirectionGetDTO(direction.get());
        }
        return null;
    }
    @Override
    public List<DirectionGetDTO> findByClientId(Integer id){
        return mapper.directionsToDirectionsDto(repository.findByClientId(id));
    }
}
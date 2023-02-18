package com.microservice.client.service.query;

import com.microservice.client.dto.DirectionCustomGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.entity.Direction;
import com.microservice.client.mapper.DirectionMapper;
import com.microservice.client.repository.DirectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public DirectionGetDTO findFirstByClientId(Integer id) {
        return mapper.directionToDirectionGetDTO(repository.findFirstByClientId(id));
    }

    @Override
    public List<DirectionGetDTO> findByClientId(Integer id){
        return mapper.directionsToDirectionsDto(repository.findByClientId(id));
    }

    @Override
    public List<DirectionCustomGetDTO> findByClientIdCustom(Integer id) {
        List<Direction> directions = repository.findByClientId(id);
        List<DirectionCustomGetDTO> customDirections = new ArrayList<>();
        for (Direction dir: directions) {
            DirectionCustomGetDTO directionCustomDto = new DirectionCustomGetDTO();
            String customDirection = dir.getCity()+", "+dir.getSector()+", "+dir.getMainStreet();
            directionCustomDto.setId(dir.getId());
            directionCustomDto.setAddress(customDirection);
            customDirections.add(directionCustomDto);
        }
        return customDirections;
    }
}

package com.microservice.client.service.command;

import com.microservice.client.dto.DirectionPostDTO;
import com.microservice.client.entity.Client;
import com.microservice.client.entity.Direction;
import com.microservice.client.mapper.ClientMapper;
import com.microservice.client.mapper.DirectionMapper;
import com.microservice.client.repository.DirectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectionCommandServiceImpl implements DirectionCommandService {
    @Autowired
    private DirectionRepository repository;
    private DirectionMapper mapper;
    private ClientMapper clientMapper;

    @Override
    public Direction save(DirectionPostDTO directionPostDTO) {
        Client c = clientMapper.clientGetDTOToClient(directionPostDTO.getClient());
        Direction d = mapper.directionPostDTOToDirection(directionPostDTO);
        d.setClient(c);
        return repository.save(d);
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
package com.microservice.client.service.command;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
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
    public DirectionGetDTO save(DirectionPostDTO directionPostDTO, ClientGetDTO clientGetDTO) {
        Client client = clientMapper.clientGetDTOToClient(clientGetDTO);
        Direction direction = mapper.directionPostDTOToDirection(directionPostDTO);
        direction.setClient(client);
        Direction dir = repository.save(direction);
        return mapper.directionToDirectionGetDTO(dir);
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
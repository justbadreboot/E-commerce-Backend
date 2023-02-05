package com.microservice.client.service.command;

import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.entity.Client;
import com.microservice.client.mapper.ClientMapper;
import com.microservice.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientCommandServiceImpl implements ClientCommandService {

    @Autowired
    private ClientRepository repository;
    private ClientMapper mapper;

    @Override
    public Client save(ClientPostDTO clientPostDTO) {
        return repository.save(mapper.clientPostDTOToClient(clientPostDTO));
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}

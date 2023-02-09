package com.microservice.client.service.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.entity.Client;
import com.microservice.client.mapper.ClientMapper;
import com.microservice.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    @Autowired
    private ClientRepository repository;

    private ClientMapper mapper;

    @Override
    public List<ClientGetDTO> findAll() {
        return mapper.clientsToClientsGetDto(repository.findAll());
    }

    @Override
    public ClientGetDTO findById(Integer id) {
        Optional<Client> client = repository.findById(id);
        if(client.isPresent()){
            return mapper.clientToClientGetDTO(client.get());
        }
        return null;
    }

    @Override
    public ClientGetDTO findbyDocument(String document) {
        return mapper.clientToClientGetDTO(repository.findByDocument(document));
    }

    @Override
    public Long countTotalClient() {
        return repository.count();
    }


}

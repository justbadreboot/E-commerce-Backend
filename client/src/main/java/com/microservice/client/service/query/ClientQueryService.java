package com.microservice.client.service.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.entity.Client;

import java.util.List;

public interface ClientQueryService {
    List<ClientGetDTO> findAll();
    ClientGetDTO findById(Integer id);
}

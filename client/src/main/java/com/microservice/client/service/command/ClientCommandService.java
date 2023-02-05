package com.microservice.client.service.command;

import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.entity.Client;

import java.util.List;

public interface ClientCommandService {
    Client save(ClientPostDTO clientPostDTO);
    void delete(Integer id);
}

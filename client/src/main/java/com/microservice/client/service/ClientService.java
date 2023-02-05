package com.microservice.client.service;

import com.microservice.client.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();
    Client findById(Integer id);
    Client save(Client client);
    void delete(Integer id);
}

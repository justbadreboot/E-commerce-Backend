package com.microservice.client.repository;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByDocument(String document);
    Client findByUserId(Integer id);

}

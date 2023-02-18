package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.service.query.ClientQueryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ClientQueryControllerTest {

    @Mock
    private ClientQueryServiceImpl clientService;

    @InjectMocks
    private ClientQueryController clientController;

    private ClientGetDTO client;
    private List<ClientGetDTO> clients;

    @BeforeEach
    void setup(){
        client = new ClientGetDTO();
        clients = new ArrayList<>();
        client.setId(1);
        client.setDocument("0930463146");
        client.setFirstName("Jonathan");
        client.setLastName("Sanchez");
        client.setPhone("0968019620");
        client.setUserId(1);
        clients.add(client);
    }

    @Test
    void controllerShouldFindAllClients(){
        Mockito.when(clientService.findAll()).thenReturn(clients);
        assertNotNull(clientController.findAllClients().getBody());
    }

    @Test
    void controllerShouldFindOneClientById(){
        Mockito.when(clientService.findById(1)).thenReturn(client);
        ResponseEntity<?> result = clientController.findClientById(1);
        assertEquals(client, result.getBody());
        Mockito.verify(clientService).findById(1);
    }
}

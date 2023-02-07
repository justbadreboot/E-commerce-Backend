package com.microservice.client.mapper;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientGetDTO clientToClientGetDTO(Client client);
    List<ClientGetDTO> clientsToClientsGetDto(List<Client> clients);
    Client clientPostDTOToClient(ClientPostDTO clientPotsDTO);
    Client clientGetDTOToClient(ClientGetDTO clientGetDTO);
}

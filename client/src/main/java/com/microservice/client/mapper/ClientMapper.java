package com.microservice.client.mapper;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.ClientPostDTO;
import com.microservice.client.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientGetDTO clientToClientGetDTO(Client client);
    Client clientPostDTOToClient(ClientPostDTO clientPotsDTO);
}

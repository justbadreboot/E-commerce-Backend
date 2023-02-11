package com.microservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientGetDTO {
    private Integer id;
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String document;
    private String phone;
}

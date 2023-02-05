package com.microservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientPostDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String document;
    private String phone;
}

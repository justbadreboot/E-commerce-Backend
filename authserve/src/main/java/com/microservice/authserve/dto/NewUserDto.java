package com.microservice.authserve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewUserDto {

    private String username;

    private String email;

    private String password;

    private String role;
}

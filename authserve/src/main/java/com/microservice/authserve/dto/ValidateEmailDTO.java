package com.microservice.authserve.dto;

import lombok.Data;

import javax.validation.constraints.Email;
@Data
public class ValidateEmailDTO {

    @Email
    private String email;
}

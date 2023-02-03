package com.microservice.landing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LandingGetDTO {

    private Integer id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String address;

    @Lob
    private String mission;

    @Lob
    private String vision;

    private String phone;

    @Email
    private String email;
}

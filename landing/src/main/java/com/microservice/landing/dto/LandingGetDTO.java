package com.microservice.landing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LandingGetDTO {

    private Integer id;

    @NotBlank
    private String name;

    @Lob
    @NotBlank
    private String description;

    @Lob
    @NotBlank
    private String address;

    @Lob
    @NotBlank
    private String mission;

    @Lob
    @NotBlank
    private String vision;

    @NotBlank
    private String phone;

    @Email
    @NotBlank
    private String email;
}

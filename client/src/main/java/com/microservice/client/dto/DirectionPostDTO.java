package com.microservice.client.dto;

import com.microservice.client.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectionPostDTO {
    private Integer id;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String sector;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String mainStreet;
    @NotBlank
    private String secondStreet;
    @NotBlank
    private String houseNumber;
}

package com.microservice.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DirectionGetDTO {
    private Integer id;
    private String city;
    private String state;
    private String sector;
    private String postalCode;
    private String mainStreet;
    private String secondStreet;
    private String houseNumber;
}
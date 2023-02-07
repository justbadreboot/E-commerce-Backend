package com.microservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentGetDTO {
    private Integer id;
    private Integer clientId;
    private LocalDateTime date;
    private Double price;
    private String duration;
    private String reason;
    private ServiceGetDto service;
}

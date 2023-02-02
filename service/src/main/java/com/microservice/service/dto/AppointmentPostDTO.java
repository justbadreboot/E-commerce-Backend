package com.microservice.service.dto;

import java.time.LocalDateTime;

public class AppointmentPostDTO {
    private Integer id;
    private Integer clientId;
    private LocalDateTime date;
    private Double price;
    private String duration;
    private String reason;
}

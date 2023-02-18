package com.microservice.service.services.query;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    AppointmentGetDTO findById(Integer id);
    List<AppointmentGetDTO> findAll();
    List<AppointmentGetDTO> findByClientId(Integer id);
}

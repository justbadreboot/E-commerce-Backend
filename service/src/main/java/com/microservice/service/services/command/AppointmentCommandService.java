package com.microservice.service.services.command;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.dto.AppointmentPostDTO;
import com.microservice.service.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentCommandService {
    Appointment save(AppointmentPostDTO appointment);
    void delete(Integer id);
}

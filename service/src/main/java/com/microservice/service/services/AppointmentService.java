package com.microservice.service.services;

import com.microservice.service.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> findById(Integer id);
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    void delete(Integer id);
}

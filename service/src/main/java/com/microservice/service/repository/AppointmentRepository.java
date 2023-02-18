package com.microservice.service.repository;

import com.microservice.service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByClientId(Integer id);
}

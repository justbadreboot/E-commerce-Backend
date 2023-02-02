package com.microservice.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Appointment extends JpaRepository<Appointment, Integer> {
}

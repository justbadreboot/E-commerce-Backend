package com.microservice.service.repository;

import com.microservice.service.entity.Especialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialtyRepository extends JpaRepository<Especialty, Integer> {
}

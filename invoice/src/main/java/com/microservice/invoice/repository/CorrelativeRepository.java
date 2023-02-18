package com.microservice.invoice.repository;

import com.microservice.invoice.entity.Correlative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrelativeRepository extends JpaRepository<Correlative, Integer> {
}

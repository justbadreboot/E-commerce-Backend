package com.microservice.service.repository;

import com.microservice.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
    List<Service> findBySpecialtyId(Integer id);
    List<Service> findTop4ByOrderByPrice();
    List<Service> findByNameContainingIgnoreCase(String prefix);
}

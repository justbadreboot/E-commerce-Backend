package com.microservice.service.repository;

import com.microservice.service.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findBySpecialtyId(Integer id);
}

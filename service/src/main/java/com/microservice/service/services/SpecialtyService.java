package com.microservice.service.services;

import com.microservice.service.entity.Specialty;

import java.util.List;

public interface SpecialtyService {

    Specialty save(Specialty specialty);
    List<Specialty> findAll();
    Specialty findById(Integer id);
    Specialty edit(Specialty specialty);
    void remove(Integer id);
}

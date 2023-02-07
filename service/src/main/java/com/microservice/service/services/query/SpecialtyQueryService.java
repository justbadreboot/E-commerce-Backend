package com.microservice.service.services.query;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Specialty;

import java.util.List;

public interface SpecialtyQueryService {
    List<SpecialtyGetDTO> findAll();
    SpecialtyGetDTO findById(Integer id);
}

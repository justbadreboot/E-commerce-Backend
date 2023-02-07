package com.microservice.service.services.command;

import com.microservice.service.dto.SpecialtyPostDTO;
import com.microservice.service.entity.Specialty;

import java.util.List;

public interface SpecialtyCommandService {
    Specialty save(SpecialtyPostDTO specialtyDto);
    void remove(Integer id);
}

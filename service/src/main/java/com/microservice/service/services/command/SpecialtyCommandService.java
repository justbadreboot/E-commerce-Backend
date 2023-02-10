package com.microservice.service.services.command;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.dto.SpecialtyPostDTO;
import com.microservice.service.entity.Specialty;

import java.util.List;

public interface SpecialtyCommandService {
    SpecialtyGetDTO save(SpecialtyPostDTO specialtyDto);
    void remove(Integer id);
}

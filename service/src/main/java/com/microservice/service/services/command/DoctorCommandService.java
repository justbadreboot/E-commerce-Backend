package com.microservice.service.services.command;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.dto.DoctorPostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Doctor;

import java.util.List;

public interface DoctorCommandService {
    DoctorGetDTO save(DoctorPostDTO doctorDto, SpecialtyGetDTO specialtyDto);
    void remove(Integer id);
}

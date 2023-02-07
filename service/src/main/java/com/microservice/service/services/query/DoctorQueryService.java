package com.microservice.service.services.query;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.entity.Doctor;

import java.util.List;

public interface DoctorQueryService {

    List<DoctorGetDTO> findAll();
    DoctorGetDTO findById(Integer id);
    List<DoctorGetDTO> findBySpecialtyId(Integer id);

}

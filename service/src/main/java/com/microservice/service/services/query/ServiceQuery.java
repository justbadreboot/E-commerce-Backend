package com.microservice.service.services.query;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.entity.Service;

import java.util.List;

public interface ServiceQuery {
    List<ServiceGetDto> findAll();
    List<ServiceGetDto> findByName(String name);
    ServiceGetDto findById(Integer id);
    List<ServiceGetDto> findBySpecialtyId(Integer id);
    List<ServiceGetDto> findMainService();
}

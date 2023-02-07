package com.microservice.service.services.command;

import com.microservice.service.dto.ServicePostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Service;

import java.util.List;

public interface ServiceCommand {
    Service create(ServicePostDTO serviceDto, SpecialtyGetDTO specialtyDto);
    void remove(Integer id);
}

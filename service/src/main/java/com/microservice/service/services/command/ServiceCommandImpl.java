package com.microservice.service.services.command;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.dto.ServicePostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Service;
import com.microservice.service.entity.Specialty;
import com.microservice.service.mapper.ServiceMapper;
import com.microservice.service.mapper.SpecialtyMapper;
import com.microservice.service.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ServiceCommandImpl implements ServiceCommand {

    @Autowired
    private ServiceRepository serviceRepository;

    private ServiceMapper serviceMapper;

    private SpecialtyMapper specialtyMapper;

    @Override
    public ServiceGetDto create(ServicePostDTO serviceDto, SpecialtyGetDTO specialtyDto) {
        Service srv = serviceMapper.toService(serviceDto);
        Specialty specialty =  specialtyMapper.specialtyGetToSpecialty(specialtyDto);
        srv.setSpecialty(specialty);
        serviceRepository.save(srv);
        return serviceMapper.toServiceDTO(srv);
    }

    @Override
    public void remove(Integer id) {
        serviceRepository.deleteById(id);
    }


}

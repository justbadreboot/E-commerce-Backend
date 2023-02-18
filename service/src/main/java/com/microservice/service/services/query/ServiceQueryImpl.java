package com.microservice.service.services.query;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.entity.Service;
import com.microservice.service.mapper.ServiceMapper;
import com.microservice.service.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ServiceQueryImpl implements ServiceQuery {

    @Autowired
    private ServiceRepository serviceRepository;

    private ServiceMapper serviceMapper;

    @Override
    public List<ServiceGetDto> findAll() {
        return serviceMapper.toServicesDTO(serviceRepository.findAll());
    }

    @Override
    public List<ServiceGetDto> findByName(String name) {
        return serviceMapper.toServicesDTO(serviceRepository.findByNameContainingIgnoreCase(name));
    }

    @Override
    public ServiceGetDto findById(Integer id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.map(value -> serviceMapper.toServiceDTO(value)).orElse(null);
    }

    @Override
    public List<ServiceGetDto> findBySpecialtyId(Integer id) {
        return serviceMapper.toServicesDTO(serviceRepository.findBySpecialtyId(id));
    }

    @Override
    public List<ServiceGetDto> findMainService() {
        return serviceMapper.toServicesDTO(serviceRepository.findTop4ByOrderByPrice());
    }
}

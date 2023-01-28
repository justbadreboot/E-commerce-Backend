package com.microservice.service.services;

import com.microservice.service.entity.Service;
import com.microservice.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class ServiceImpl implements IService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service create(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Integer id) {
        Optional<Service> service = serviceRepository.findById(id);
        return service.orElse(null);
    }

    @Override
    public Service update(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        serviceRepository.deleteById(id);
    }
}

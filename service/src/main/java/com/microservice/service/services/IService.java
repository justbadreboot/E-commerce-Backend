package com.microservice.service.services;

import com.microservice.service.entity.Service;

import java.util.List;

public interface IService {
    Service create(Service service);
    List<Service> findAll();
    Service findById(Integer id);
    Service update(Service service);
    void remove(Integer id);
}

package com.microservice.service.services;

import com.microservice.service.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor save(Doctor doctor);
    List<Doctor> findAll();
    Doctor findById(Integer id);
    Doctor edit(Doctor doctor);
    void remove(Integer id);
    List<Doctor> findBySpecialtyId(Integer id);

}

package com.microservice.service.services;

import com.microservice.service.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor save(Doctor doctor);
    List<Doctor> finAll();
    Doctor findById(Integer id);
    Doctor edit(Doctor doctor);
    void remove(Integer id);

}

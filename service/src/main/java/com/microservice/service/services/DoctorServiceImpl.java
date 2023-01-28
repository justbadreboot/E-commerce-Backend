package com.microservice.service.services;

import com.microservice.service.entity.Doctor;
import com.microservice.service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> finAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Integer id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    @Override
    public Doctor edit(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void remove(Integer id) {
        doctorRepository.deleteById(id);
    }
}

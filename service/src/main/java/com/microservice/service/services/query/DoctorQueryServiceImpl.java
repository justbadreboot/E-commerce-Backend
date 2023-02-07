package com.microservice.service.services.query;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.entity.Doctor;
import com.microservice.service.mapper.DoctorMapper;
import com.microservice.service.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorQueryServiceImpl implements DoctorQueryService {
    @Autowired
    private DoctorRepository doctorRepository;

    private DoctorMapper doctorMapper;
    @Override
    public List<DoctorGetDTO> findAll() {
        return doctorMapper.toDoctorsDTO(doctorRepository.findAll());
    }

    @Override
    public DoctorGetDTO findById(Integer id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.map(value -> doctorMapper.toDoctorDTO(value)).orElse(null);
    }

    @Override
    public List<DoctorGetDTO> findBySpecialtyId(Integer id) {
        return doctorMapper.toDoctorsDTO(doctorRepository.findBySpecialtyId(id));
    }

}

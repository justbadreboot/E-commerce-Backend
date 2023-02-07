package com.microservice.service.services.command;

import com.microservice.service.dto.DoctorPostDTO;
import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Doctor;
import com.microservice.service.entity.Specialty;
import com.microservice.service.mapper.DoctorMapper;
import com.microservice.service.mapper.SpecialtyMapper;
import com.microservice.service.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorCommandServiceImpl implements DoctorCommandService {
    @Autowired
    private DoctorRepository doctorRepository;

    private DoctorMapper doctorMapper;
    private SpecialtyMapper specialtyMapper;

    @Override
    public Doctor save(DoctorPostDTO doctorDto, SpecialtyGetDTO specialtyDto) {
        Doctor doctor = doctorMapper.toDoctor(doctorDto);
        Specialty specialty = specialtyMapper.specialtyGetToSpecialty(specialtyDto);
        doctor.setSpecialty(specialty);
        return doctorRepository.save(doctor);
    }

    @Override
    public void remove(Integer id) {
        doctorRepository.deleteById(id);
    }


}

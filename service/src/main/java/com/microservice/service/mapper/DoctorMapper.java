package com.microservice.service.mapper;

import com.microservice.service.dto.DoctorGetDTO;
import com.microservice.service.dto.DoctorPostDTO;
import com.microservice.service.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorGetDTO toDoctorDTO(Doctor doctor);
    List<DoctorGetDTO> toDoctorsDTO(List<Doctor> doctors);
    Doctor toDoctor(DoctorPostDTO doctorDTO);
}

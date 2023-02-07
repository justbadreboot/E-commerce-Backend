package com.microservice.service.mapper;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.dto.SpecialtyPostDTO;
import com.microservice.service.entity.Specialty;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {
    SpecialtyGetDTO toSpecialtyDTO(Specialty specialty);
    List<SpecialtyGetDTO> toSpecialtiesDTO(List<Specialty> specialties);
    SpecialtyPostDTO toSpecialty(SpecialtyPostDTO specialtyDTO);
}

package com.microservice.service.services.query;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.entity.Specialty;
import com.microservice.service.mapper.SpecialtyMapper;
import com.microservice.service.repository.SpecialtyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class SpecialtyQueryServiceImpl implements SpecialtyQueryService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    private SpecialtyMapper specialtyMapper;

    @Override
    public List<SpecialtyGetDTO> findAll() {
        return specialtyMapper.toSpecialtiesDTO(specialtyRepository.findAll());
    }

    @Override
    public SpecialtyGetDTO findById(Integer id) {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        return specialty.map(value->specialtyMapper.toSpecialtyDTO(value)).orElse(null);
    }
}

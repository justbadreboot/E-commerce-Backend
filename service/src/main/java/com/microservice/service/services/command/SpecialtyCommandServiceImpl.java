package com.microservice.service.services.command;

import com.microservice.service.dto.SpecialtyPostDTO;
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
public class SpecialtyCommandServiceImpl implements SpecialtyCommandService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    private SpecialtyMapper specialtyMapper;

    @Override
    public Specialty save(SpecialtyPostDTO specialtyDto) {
        return specialtyRepository.save(specialtyMapper.toSpecialty(specialtyDto));
    }

    @Override
    public void remove(Integer id) {
        specialtyRepository.deleteById(id);
    }
}

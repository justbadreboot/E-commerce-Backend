package com.microservice.service.services;

import com.microservice.service.entity.Specialty;
import com.microservice.service.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService{

    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Override
    public Specialty create(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty findById(Integer id) {
        Optional<Specialty> specialty = specialtyRepository.findById(id);
        return specialty.orElse(null);
    }

    @Override
    public Specialty edit(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void remove(Integer id) {
        specialtyRepository.deleteById(id);
    }
}

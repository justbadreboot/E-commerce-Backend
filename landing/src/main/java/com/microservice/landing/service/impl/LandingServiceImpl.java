package com.microservice.landing.service.impl;

import com.microservice.landing.entity.Landing;
import com.microservice.landing.repository.LandingRepository;
import com.microservice.landing.service.LandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LandingServiceImpl implements LandingService {

    @Autowired
    private LandingRepository landingRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Landing> information() {
        return landingRepository.findAll();
    }

    @Override
    public Optional<Landing> editInfoById(Integer id) {
        return landingRepository.findById(id);
    }
}

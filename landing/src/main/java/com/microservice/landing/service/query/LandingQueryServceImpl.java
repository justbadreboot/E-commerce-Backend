package com.microservice.landing.service.query;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.entity.Landing;
import com.microservice.landing.mapper.LandingMapper;
import com.microservice.landing.repository.LandingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

@Slf4j
public class LandingQueryServceImpl implements LandingQueryService{

    private LandingMapper landingMapper;

    @Autowired
    private LandingRepository landingRepository;

    @Override
    //@Transactional(readOnly = true)
    public List<Landing> readInformation() {
        //List<Landing> landing = landingRepository.findAll();
        //log.info("datos {}", landing);
        log.info("Obtencion de info");
        return landingRepository.findAll();
    }

    @Override
    public Optional<Landing> readLandingById(Integer id) {
        return landingRepository.findById(id);
    }
}

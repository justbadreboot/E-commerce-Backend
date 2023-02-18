package com.microservice.landing.service.commands;

import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;
import com.microservice.landing.mapper.LandingMapper;
import com.microservice.landing.repository.LandingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LandingCommandServiceImpl implements LandingCommandService{

    private LandingMapper landingMapper;
    @Autowired
    private LandingRepository landingRepository;

    @Override
    public void saveLandingInformation(LandingPostDTO landingPostDTO) {
        landingRepository.save(landingMapper.dtoToLandingEntity(landingPostDTO));
    }

    @Override
    public void updateLandingInformation(LandingPostDTO landingPostDTO, Landing landing) {
        landing.setName(landingPostDTO.getName());
        landing.setDescription(landingPostDTO.getDescription());
        landing.setPhone(landingPostDTO.getPhone());
        landing.setEmail(landingPostDTO.getEmail());
        landing.setAddress(landingPostDTO.getAddress());
        landing.setVision(landingPostDTO.getVision());
        landing.setMission(landingPostDTO.getMission());

    }
}

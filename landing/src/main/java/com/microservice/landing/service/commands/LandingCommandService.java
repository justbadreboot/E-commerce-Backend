package com.microservice.landing.service.commands;

import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;

public interface LandingCommandService {

    void saveLandingInformation(LandingPostDTO landingPostDTO);

    void updateLandingInformation(LandingPostDTO landingPostDTO, Landing landing);

}

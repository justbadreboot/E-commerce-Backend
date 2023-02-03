package com.microservice.landing.service.query;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.entity.Landing;

import java.util.List;
import java.util.Optional;

public interface LandingQueryService {

    List<Landing> readInformation();

    Optional<Landing> readLandingById(Integer id);

}

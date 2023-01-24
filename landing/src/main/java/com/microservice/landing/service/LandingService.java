package com.microservice.landing.service;

import com.microservice.landing.entity.Landing;

import java.util.List;
import java.util.Optional;

public interface LandingService {

    List<Landing> information();

    Optional<Landing> editInfoById(Integer id);


}

package com.microservice.landing.repository;

import com.microservice.landing.entity.Landing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandingRepository extends JpaRepository<Landing, Integer> {

}

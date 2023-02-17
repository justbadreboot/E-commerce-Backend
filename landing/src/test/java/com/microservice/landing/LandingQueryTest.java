package com.microservice.landing;

import com.microservice.landing.controller.LandingQueryController;
import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.entity.Landing;
import com.microservice.landing.repository.LandingRepository;
import com.microservice.landing.service.query.LandingQueryServceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LandingQueryTest {


    @InjectMocks
    private Landing landing;

    @Mock
    private LandingRepository landingRepository;

    @Test
    void verLandingPage(){
        when(landingRepository.findAll()).thenReturn(Arrays.asList(landing));
        assertNotNull(landingRepository.findAll());
    }
}

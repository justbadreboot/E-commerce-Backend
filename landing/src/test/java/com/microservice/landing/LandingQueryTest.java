package com.microservice.landing;

import com.microservice.landing.entity.Landing;
import com.microservice.landing.repository.LandingRepository;
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
class LandingQueryTest {


    @InjectMocks
    private Landing landing;

    @Mock
    private LandingRepository landingRepository;

    @Test
    void verLandingPage(){
        when(landingRepository.findAll()).thenReturn(List.of(landing));
        assertNotNull(landingRepository.findAll());
    }

}

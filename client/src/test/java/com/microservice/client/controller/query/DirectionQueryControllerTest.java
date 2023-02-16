package com.microservice.client.controller.query;

import com.microservice.client.dto.ClientGetDTO;
import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.service.query.ClientQueryServiceImpl;
import com.microservice.client.service.query.DirectionQueryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DirectionQueryControllerTest {

    @Mock
    private DirectionQueryServiceImpl directionService;

    @InjectMocks
    private DirectionQueryController directionController;

    private DirectionGetDTO direction;
    private List<DirectionGetDTO> directions;

    @BeforeEach
    void setup(){
        direction = new DirectionGetDTO();
        directions = new ArrayList<>();
        direction.setId(1);
        direction.setState("Esmeraldas");
        direction.setCity("Esmeraldas");
        direction.setSector("Hospital de IESS");
        direction.setMainStreet("Morona");
        direction.setSecondStreet("Colon");
        direction.setPostalCode("110110");
        directions.add(direction);
    }

    @Test
    void controllerShouldFindOneDirectionById(){
        Mockito.when(directionService.findById(1)).thenReturn(direction);
        ResponseEntity<?> result = directionController.findDirectionById(1);
        assertEquals(direction, result.getBody());
        Mockito.verify(directionService).findById(1);
    }



}

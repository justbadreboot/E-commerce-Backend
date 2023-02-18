package com.microservice.service.controller.query;

import com.microservice.service.dto.SpecialtyGetDTO;
import com.microservice.service.services.query.SpecialtyQueryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SpecialtyQueryControllerTest {

    @Mock
    private SpecialtyQueryServiceImpl specialtyService;

    @InjectMocks
    private SpecialtyQueryController specialtyController;

    private SpecialtyGetDTO specialtyDto;
    private List<SpecialtyGetDTO> specialtiesDto;

    @BeforeEach
    void setup(){
        specialtyDto = new SpecialtyGetDTO(1,"Consulta General");
        specialtiesDto = List.of(specialtyDto);
    }

    @Test
    void controllerShouldFindAllSpecialties(){
        Mockito.when(specialtyService.findAll()).thenReturn(specialtiesDto);
        assertNotNull(specialtyController.findAllSpecialties().getBody());
    }

    @Test
    void controllerShouldFindOneSpecialtyById(){
        Mockito.when(specialtyService.findById(1)).thenReturn(specialtyDto);
        ResponseEntity<?> result = specialtyController.findSpecialtyById(1);
        assertEquals(specialtyDto, result.getBody());
        Mockito.verify(specialtyService).findById(1);
    }

}

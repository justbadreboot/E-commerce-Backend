package com.microservice.landing.mapper;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface LandingMapper {


    //se convierte a un DTO una entidad
    List<LandingGetDTO> toLandigDTO(List<Landing> landing);



    //Mapea campos para convertir a una entidad un DTO
    @Mapping(target = "id", ignore = true)
    Landing toLandingDto(LandingPostDTO landing);

}

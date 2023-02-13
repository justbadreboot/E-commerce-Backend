package com.microservice.landing.mapper;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LandingMapper {


    LandingGetDTO toLandingDTO (Landing landing);
    //se convierte a un DTO una entidad
    //recibe una entidad y lo convierte en un DTO
    List<LandingGetDTO> toLandigDTOUni(List<Landing> landing);

    //Optional<LandingPostDTO> landingToDtoPost(Optional<Landing> landing);



    //Mapea campos para convertir a una entidad un DTO
    //Recibe un DTO y lo convierte en una entidad
    //@Mapping(target = "id", ignore = true)
    //Optional<Landing> dtoToLanding(Optional<LandingPostDTO> landingPostDTO);


    Landing dtoToLandingEntity(LandingPostDTO landingPostDTO);

  //  LandingPostDTO landingToDtoPost(Landing landing);


}

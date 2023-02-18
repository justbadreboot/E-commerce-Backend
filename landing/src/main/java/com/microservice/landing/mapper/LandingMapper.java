package com.microservice.landing.mapper;

import com.microservice.landing.dto.LandingGetDTO;
import com.microservice.landing.dto.LandingPostDTO;
import com.microservice.landing.entity.Landing;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LandingMapper {


    LandingGetDTO toLandingDTO (Landing landing);

    List<LandingGetDTO> toLandigDTOUni(List<Landing> landing);


    Landing dtoToLandingEntity(LandingPostDTO landingPostDTO);



}

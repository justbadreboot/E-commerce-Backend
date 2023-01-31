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

    List<LandingGetDTO> toLandigDTO(List<Landing> landing);



    @Mapping(target = "id", ignore = true)
    Landing toLandingDto(LandingPostDTO landing);

}

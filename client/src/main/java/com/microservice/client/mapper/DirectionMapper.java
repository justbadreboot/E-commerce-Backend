package com.microservice.client.mapper;

import com.microservice.client.dto.DirectionGetDTO;
import com.microservice.client.dto.DirectionPostDTO;
import com.microservice.client.entity.Direction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectionMapper {
    DirectionGetDTO directionToDirectionGetDTO(Direction direction);
    List<DirectionGetDTO> directionsToDirectionsDto(List<Direction> directions);
    Direction directionPostDTOToDirection(DirectionPostDTO directionPostDTO);
}

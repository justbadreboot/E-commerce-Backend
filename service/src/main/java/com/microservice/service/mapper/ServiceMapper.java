package com.microservice.service.mapper;

import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.dto.ServicePostDTO;
import com.microservice.service.entity.Service;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceGetDto toServiceDTO(Service srv);
    List<ServiceGetDto> toServicesDTO(List<Service> srvs);
    Service toService(ServicePostDTO srvDTO);
}

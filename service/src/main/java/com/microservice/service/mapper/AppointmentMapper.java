package com.microservice.service.mapper;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.dto.AppointmentPostDTO;
import com.microservice.service.entity.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentGetDTO toAppoinmentDTO(Appointment app);
    Appointment toAppoinment(AppointmentGetDTO appDTO);
    List<AppointmentGetDTO> toAppointmentsDTO(List<Appointment> apps);
    Appointment toAppointment(AppointmentPostDTO appPostDTO);
}

package com.microservice.service.services.command;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.dto.AppointmentPostDTO;
import com.microservice.service.dto.ServiceGetDto;
import com.microservice.service.entity.Appointment;
import com.microservice.service.mapper.AppointmentMapper;
import com.microservice.service.mapper.ServiceMapper;
import com.microservice.service.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentCommandServiceImpl implements AppointmentCommandService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private AppointmentMapper appointmentMapper;
    private ServiceMapper serviceMapper;

    @Override
    public Appointment save(AppointmentPostDTO appointmentDto, ServiceGetDto serviceDto) {
        Appointment appointment = appointmentMapper.toAppointment(appointmentDto);
        appointment.setService(serviceMapper.serviceDtotoService(serviceDto));
        return appointmentRepository.save(appointment);
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }
}

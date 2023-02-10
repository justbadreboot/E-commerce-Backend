package com.microservice.service.services.query;

import com.microservice.service.dto.AppointmentGetDTO;
import com.microservice.service.entity.Appointment;
import com.microservice.service.mapper.AppointmentMapper;
import com.microservice.service.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentQueryServiceImpl implements AppointmentQueryService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private AppointmentMapper appointmentMapper;

    @Override
    public AppointmentGetDTO findById(Integer id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            return appointmentMapper.toAppoinmentDTO(appointment.get());
        }
        return null;
    }

    @Override
    public List<AppointmentGetDTO> findAll() {
        return appointmentMapper.toAppointmentsDTO(appointmentRepository.findAll());
    }

    @Override
    public List<AppointmentGetDTO> findByClientId(Integer id) {
        return appointmentMapper.toAppointmentsDTO(appointmentRepository.findByClientId(id));
    }

}

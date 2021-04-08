package com.heap.heap_project.services;

import com.heap.heap_project.models.Appointment;
import com.heap.heap_project.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;

    @Override
    public Optional<Appointment> findByIdServ(int id){
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAllServ(){
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment insertServ(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateServ(int id, Appointment appointment){
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if(optionalAppointment.isPresent()) {
            return appointmentRepository.save(appointment);
        }
        return null;
    }

    @Override
    public void deleteServ(int id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()) {
            appointmentRepository.delete(appointment.get());
        }
    }
}

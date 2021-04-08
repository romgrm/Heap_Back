package com.heap.heap_project.services;

import com.heap.heap_project.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> findByIdServ(int id);
    List<Appointment> findAllServ();
    Appointment insertServ(Appointment appointment);
    Appointment updateServ(int id, Appointment appointment);
    void deleteServ(int id);
}

package com.heap.heap_project.controllers;

import com.heap.heap_project.models.Appointment;
import com.heap.heap_project.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/appointment")
@AllArgsConstructor
public class AppointmentController {
    final private AppointmentService appointmentService;

    /*
        GET all Appointment
    */
    @GetMapping
    ResponseEntity<List<Appointment>> getAllppointments() {
        return ResponseEntity.ok().body(
                appointmentService.findAllServ()
        );
    }

    /*
        GET Appointment by Id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Appointment>> appointmentById(@PathVariable int id) {
        return ResponseEntity.ok(appointmentService.findByIdServ(id));
    }

    @PostMapping()
    ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment){
        return ResponseEntity.ok().body(appointmentService.insertServ(appointment));
    }
}

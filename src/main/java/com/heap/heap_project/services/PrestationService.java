package com.heap.heap_project.services;

import com.heap.heap_project.models.Prestation;

import java.util.List;
import java.util.Optional;

public interface PrestationService {
    Optional<Prestation> findByIdServ(int id);
    List<Prestation> findAllServ();
    Prestation insertServ(Prestation prestation);
    Prestation updateServ(int id, Prestation prestation);
    void deleteServ(int id);
}

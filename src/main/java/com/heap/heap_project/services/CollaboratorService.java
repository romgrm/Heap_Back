package com.heap.heap_project.services;

import com.heap.heap_project.models.Collaborator;

import java.util.List;
import java.util.Optional;

public interface CollaboratorService {
    Optional<Collaborator> findByIdServ(int id);
    List<Collaborator> findAllServ();
    Collaborator insertServ(Collaborator collaborator);
    Collaborator updateServ(int id, Collaborator collaborator);
    void deleteServ(int id);
}

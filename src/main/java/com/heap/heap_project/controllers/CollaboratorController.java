package com.heap.heap_project.controllers;

import com.heap.heap_project.models.Collaborator;
import com.heap.heap_project.services.CollaboratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/collaborator")
@AllArgsConstructor
public class CollaboratorController {

    final private CollaboratorService collaboratorService;

    /*
        GET all Collaborator
    */
    @GetMapping
    ResponseEntity<List<Collaborator>> getAllCollaborators() {
        return ResponseEntity.ok().body(
                collaboratorService.findAllServ()
        );
    }

    /*
        GET Collaborator by Id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Collaborator>> collaboratorById(@PathVariable int id) {
        return ResponseEntity.ok(collaboratorService.findByIdServ(id));
    }

    @PostMapping()
    ResponseEntity<Collaborator> addCollaborator(@RequestBody Collaborator collaborator){
        return ResponseEntity.ok().body(collaboratorService.insertServ(collaborator));
    }
}

package com.heap.heap_project.controllers;

import com.heap.heap_project.models.Prestation;
import com.heap.heap_project.services.PrestationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/prestation")
@AllArgsConstructor
public class PrestationController {
    final private PrestationService prestationService;

    /*
        GET all Prestation
    */
    @GetMapping
    ResponseEntity<List<Prestation>> getAllPrestations() {
        return ResponseEntity.ok().body(
                prestationService.findAllServ()
        );
    }

    /*
        GET Prestation by Id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Prestation>> collaboratorById(@PathVariable int id) {
        return ResponseEntity.ok(prestationService.findByIdServ(id));
    }

    @PostMapping()
    ResponseEntity<Prestation> addCollaborator(@RequestBody Prestation prestation){
        return ResponseEntity.ok().body(prestationService.insertServ(prestation));
    }
}

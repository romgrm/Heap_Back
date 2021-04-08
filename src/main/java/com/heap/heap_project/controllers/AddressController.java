package com.heap.heap_project.controllers;

import com.heap.heap_project.models.Address;
import com.heap.heap_project.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    final private AddressService addressService;

    /*
        GET all Address
    */
    @GetMapping
    ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok().body(
                addressService.findAllServ()
        );
    }

    /*
        GET Address by Id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> addressById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.findByIdServ(id));
    }

    @PostMapping()
    ResponseEntity<Address> addCollaborator(@RequestBody Address address){
        return ResponseEntity.ok().body(addressService.insertServ(address));
    }
}

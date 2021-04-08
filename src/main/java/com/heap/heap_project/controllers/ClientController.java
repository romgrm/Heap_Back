package com.heap.heap_project.controllers;
import com.heap.heap_project.models.Client;
import com.heap.heap_project.repositories.ClientRepository;
import com.heap.heap_project.services.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {


    final private ClientServiceImpl clientService;
    final private ClientRepository clientRepository;


    /*
        GET all Client
    */
    @GetMapping
    ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok().body(
            clientService.findAllClientsServ()
        );
    }

    /*
        GET Client by Id
    */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findClientById(@PathVariable int id) {
        return ResponseEntity.ok(clientService.findClientByIdServ(id));
    }

    /*
        Update Client
    */
    @PutMapping("/{id}")
    ResponseEntity<Client> updateClient(@PathVariable(value = "id") int id, @RequestBody Client client) {
        clientService.updateServ(id, client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    /*
        Create Client
    */
    @PostMapping()
    ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.ok().body(clientService.addClientServ(client));
    }

    /*
        Delete Client
    */
    @DeleteMapping("{id}")
    ResponseEntity<Client> deleteClient(@PathVariable(value="id") int id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty())
            return ResponseEntity.notFound().build();

        clientService.deleteClientServ(client.get().getId());
        return ResponseEntity.accepted().build();
    }

    @PreAuthorize("hasRole('ROLE_PARTICULIER')")
    @GetMapping(path = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("ça marche");
    }

}

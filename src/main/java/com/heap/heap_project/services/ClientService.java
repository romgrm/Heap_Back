package com.heap.heap_project.services;
import com.heap.heap_project.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Optional<Client> findClientByIdServ(int id);
    List<Client> findAllClientsServ();
    Client addClientServ(Client client);
    void updateServ(int id, Client client);
    void deleteClientServ(int id);
    Client checkClientExist(int clientId);
}

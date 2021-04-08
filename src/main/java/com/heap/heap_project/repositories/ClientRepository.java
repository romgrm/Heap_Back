package com.heap.heap_project.repositories;

import com.heap.heap_project.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByEmail(String email);

}

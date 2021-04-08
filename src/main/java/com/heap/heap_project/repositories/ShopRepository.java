package com.heap.heap_project.repositories;

import com.heap.heap_project.models.Client;
import com.heap.heap_project.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    Optional<Shop> findByEmail(String email);

}

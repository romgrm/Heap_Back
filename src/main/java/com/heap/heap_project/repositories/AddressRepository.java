package com.heap.heap_project.repositories;

import com.heap.heap_project.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

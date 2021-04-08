package com.heap.heap_project.services;

import com.heap.heap_project.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> findByIdServ(int id);
    List<Address> findAllServ();
    Address insertServ(Address address);
    Address updateServ(int id, Address address);
    void deleteServ(int id);
}

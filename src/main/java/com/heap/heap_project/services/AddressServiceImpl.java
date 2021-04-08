package com.heap.heap_project.services;

import com.heap.heap_project.models.Address;
import com.heap.heap_project.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Optional<Address> findByIdServ(int id){
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAllServ(){
        return addressRepository.findAll();
    }

    @Override
    public Address insertServ(Address address){
        return addressRepository.save(address);
    }

    @Override
    public Address updateServ(int id, Address address){
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if(optionalAddress.isPresent()) {
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public void deleteServ(int id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()) {
            addressRepository.delete(address.get());
        }
    }
}

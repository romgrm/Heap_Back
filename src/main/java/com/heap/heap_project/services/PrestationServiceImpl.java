package com.heap.heap_project.services;

import com.heap.heap_project.models.Prestation;
import com.heap.heap_project.repositories.PrestationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrestationServiceImpl implements PrestationService{

    private final PrestationRepository prestationRepository;

    @Override
    public Optional<Prestation> findByIdServ(int id){
        return prestationRepository.findById(id);
    }

    @Override
    public List<Prestation> findAllServ(){
        return prestationRepository.findAll();
    }

    @Override
    public Prestation insertServ(Prestation prestation){
        return prestationRepository.save(prestation);
    };

    @Override
    public Prestation updateServ(int id, Prestation prestation){
        Optional<Prestation> optionalPrestation = prestationRepository.findById(id);
        if(optionalPrestation.isPresent()) {
            return prestationRepository.save(prestation);
        }
        return null;
    };

    @Override
    public void deleteServ(int id){
        Optional<Prestation> prestation = prestationRepository.findById(id);
        if(prestation.isPresent()) {
            prestationRepository.delete(prestation.get());
        }
    };
}

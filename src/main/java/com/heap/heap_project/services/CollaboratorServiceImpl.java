package com.heap.heap_project.services;

import com.heap.heap_project.models.Collaborator;
import com.heap.heap_project.repositories.CollaboratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CollaboratorServiceImpl implements CollaboratorService{


    private final CollaboratorRepository collaboratorRepository;

    @Override
    public Optional<Collaborator> findByIdServ(int id){
        return collaboratorRepository.findById(id);
    }

    @Override
    public List<Collaborator> findAllServ(){
        return collaboratorRepository.findAll();
    }

    @Override
    public Collaborator insertServ(Collaborator collaborator){
        return collaboratorRepository.save(collaborator);
    };

    @Override
    public Collaborator updateServ(int id, Collaborator collaborator){
        Optional<Collaborator> optionalCollaborator = collaboratorRepository.findById(id);
        if(optionalCollaborator.isPresent()) {
            return collaboratorRepository.save(collaborator);
        }
        return null;
    };

    @Override
    public void deleteServ(int id){
        Optional<Collaborator> collaborator = collaboratorRepository.findById(id);
        if(collaborator.isPresent()) {
            collaboratorRepository.delete(collaborator.get());
        }
    };
}

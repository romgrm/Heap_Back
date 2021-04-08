package com.heap.heap_project.services;

import com.heap.heap_project.models.Address;
import com.heap.heap_project.models.Client;
import com.heap.heap_project.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{

    // Import du repository pour avoir accès au différentes méthodes JPA
    private final ClientRepository clientRepository;


    @Override
    public Optional<Client> findClientByIdServ(int id){
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAllClientsServ(){
        return clientRepository.findAll();
    }

    @Override
    public Client addClientServ(Client client){
        return clientRepository.save(client);
    }

    @Override
    public void updateServ(int id, Client newClient){

        /*
            On appelle la méthode updateServ() avec comme arg reçu les données du Newclient avec un id
            On appelle la method checkClientExist pour voir si l'id envoyé correspond à un client dans notre bdd, si oui on stock ce client dans localClient
            Ensuite on check les différentes valeurs entrées dans notre newClient (null, qlq chose d'écrit, valeur différente à celle existante etc)
            Si tout ça est ok, on applique la nouvelle valeur en entrée (newClient.get()) à celle en bdd (localClient.set())
        */
        Client localClient = checkClientExist(id);

        /*
            On extrait l'objet Address contenu dans Client afin d'avoir directement accès aux variables (getCity(), getStreet()...)
            newAddress est l'adresse rentrée par le client en paramètre
            localAddress est l'adresse d'un client stocké en BDD
            On peut ensuite comparer les éléments entrés et si tout est ok les affecter à l'adresse stockée dans notre BDD
            On fait directement l'adresse ici car elle sera toujours reliée à un compte (client/shop)
        * */
        Address newAddress = newClient.getPersonAddress();
        Address localAddress = localClient.getPersonAddress();

        if(newClient.getFirstName() != null
            && newClient.getFirstName().length() > 0
                && !newClient.getFirstName().equals(localClient.getFirstName())) {
           localClient.setFirstName(newClient.getFirstName());
        }
        if(newClient.getLastName() != null
                && newClient.getLastName().length() > 0
                && !newClient.getLastName().equals(localClient.getLastName())) {
            localClient.setLastName(newClient.getLastName());
        }
        if(newClient.getCivility() != null
                && newClient.getCivility().name().length() > 0
                && !newClient.getCivility().equals(localClient.getCivility())) {
            localClient.setCivility(newClient.getCivility());
        }
        if(newAddress.getCity() != null
                && !newAddress.getCity().equals(localAddress.getCity())) {
            localAddress.setCity(newAddress.getCity());
        }
        if(newAddress.getStreet() != null
                && !newAddress.getStreet().equals(localAddress.getStreet())) {
            localAddress.setStreet(newAddress.getStreet());
        }
        if(newAddress.getNumber() != null
                && !newAddress.getNumber().equals(localAddress.getNumber())){
            localAddress.setNumber(newAddress.getNumber());
        }
        if(newAddress.getZipCode() != 0
                && newAddress.getZipCode() != localAddress.getZipCode()) {
            localAddress.setCity(newAddress.getCity());
        }
        if(newAddress.getAddressComplement() != null
            && !newAddress.getAddressComplement().equals(localAddress.getAddressComplement())){
            localAddress.setAddressComplement(newAddress.getAddressComplement());
        }

        clientRepository.save(localClient);
    };

    @Override
    public void deleteClientServ(int id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
            clientRepository.delete(client.get());
        }
    };

    /*Vérifie si le client existe en fonction de l'id entré , retourne une error si il n'existe pas */
    @Override
    public Client checkClientExist(int clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le client " + clientId + "n'existe pas"));
    }

}

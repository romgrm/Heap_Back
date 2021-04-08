package com.heap.heap_project.security.auth;

import com.heap.heap_project.models.Client;
import com.heap.heap_project.models.Shop;
import com.heap.heap_project.repositories.ClientRepository;
import com.heap.heap_project.repositories.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ClientRepository clientRepository;
    private final ShopRepository shopRepository;
    

    // Récupération d'un user en BDD en fonction de son username
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (clientRepository.findByEmail(email).isPresent()) {
            return clientRepository.findByEmail(email).orElse (null);
        } else if (shopRepository.findByEmail(email).isPresent()) {
            return shopRepository.findByEmail(email).orElse(null);
        } else throw new UsernameNotFoundException("L'utilisateur dont l'email est: " + email + " est introuvable");
    }

    // Création d'un user
    public Client signUpUser(Client newClient){

        if(clientRepository
                .findByEmail(newClient.getEmail())
                .isPresent()) {
            throw new IllegalStateException("Cet email est déjà utilisé");
        }

        // On encode le mdp pour le reinjecter dans le client qu'on enregistre ensuite
        String encodedPassword = bCryptPasswordEncoder.encode(newClient.getPassword());
        newClient.setPassword(encodedPassword);

        // Enregistrement du user dans la BDD
        clientRepository.save(newClient);
        // Met à jour la bdd de clients
        clientRepository.flush();

        return newClient;
    }

    public Shop signUpShop(Shop newShop) {

        if(shopRepository
                .findByEmail(newShop.getEmail())
                .isPresent()) {
            throw new IllegalStateException("Cet email est déjà utilisé");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(newShop.getPassword());
        newShop.setPassword(encodedPassword);

        // Enregistrement du user dans la BDD
        shopRepository.save(newShop);
        clientRepository.flush();

        return newShop;
    }



}

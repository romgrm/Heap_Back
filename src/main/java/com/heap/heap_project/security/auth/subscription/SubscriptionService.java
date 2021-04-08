package com.heap.heap_project.security.auth.subscription;

import com.heap.heap_project.models.Client;
import com.heap.heap_project.models.Shop;
import com.heap.heap_project.security.auth.ApplicationUserRole;
import com.heap.heap_project.security.auth.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

    // Le service contient notre méthode de récupération d'un user en BDD loadByUsername(), mais aussi la méthode pour créer un user signUpUser()
    private final ApplicationUserService applicationUserService;

    // On crée un nouvel user avec les éléments de la request reçue qu'on passe en paramètre de la fonction "signUpUser"
    // qui enregistrera le user dans la BDD
    public Client registerUsersServ(SubscriptionRequestTemplate request) {

        return applicationUserService.signUpUser(
                new Client(
                        request.getEmail(),
                        request.getPassword(),
                        ApplicationUserRole.PARTICULIER
                )
        );
    }

    public Shop registerShopServ(SubscriptionRequestTemplate request) {

        return applicationUserService.signUpShop(
                new Shop(
                        request.getEmail(),
                        request.getPassword(),
                        ApplicationUserRole.PRO
                )
        );
    }
}

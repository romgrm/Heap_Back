package com.heap.heap_project.security.auth.subscription;

import com.heap.heap_project.models.Client;
import com.heap.heap_project.models.Shop;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/inscription")
public class SubscriptionController {

    public SubscriptionService subscriptionService;

    // Appel de la fonction permettant la création d'un nouvel user particulier
    @PostMapping(path = "/utilisateur")
    public ResponseEntity<Client> registerUsers(@RequestBody SubscriptionRequestTemplate request) {
        return ResponseEntity.ok().body(
                subscriptionService.registerUsersServ(request));
    }
    // Appel de la fonction permettant la création d'un nouvel user professionnel
    @PostMapping(path = "/shop")
    public ResponseEntity<Shop> registerShops(@RequestBody SubscriptionRequestTemplate request) {
        return ResponseEntity.ok().body(
                subscriptionService.registerShopServ(request));
    }


}

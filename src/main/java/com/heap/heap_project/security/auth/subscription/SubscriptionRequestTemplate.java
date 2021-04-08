package com.heap.heap_project.security.auth.subscription;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
// Template envoyé à l'utilisateur pour créer son compte qu'on utilise dans SubscriptionController
public class SubscriptionRequestTemplate {

    private String email;
    private String password;

}

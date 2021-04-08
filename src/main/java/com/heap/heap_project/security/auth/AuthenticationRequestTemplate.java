package com.heap.heap_project.security.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthenticationRequestTemplate {

    private String username;
    private String password;
}

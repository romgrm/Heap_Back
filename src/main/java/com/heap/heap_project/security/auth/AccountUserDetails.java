package com.heap.heap_project.security.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heap.heap_project.models.Civility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
// Template de base pour créer un utilisateur avec security
public class AccountUserDetails implements UserDetails {

    // Non vide avec validation de type mail
    @NotEmpty
    @Email(message = "Votre email doit être valide")
    private String email;

    @NotEmpty
//    @Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
//            message="Votre mot de passe doit contenir au moins 8 charactères, avec au moins une lettre, un nombre et un charactère spécial")
    @JsonIgnore
    private String password;
//    @NotEmpty
    private String lastName;
//    @NotEmpty
    private String firstName;

    @Enumerated(EnumType.STRING)
    Civility civility;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    ApplicationUserRole role;

    @JsonIgnore
    private Boolean locked = false;

    @JsonIgnore
    private Boolean enabled = true;


    public AccountUserDetails(String email, String password, ApplicationUserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public AccountUserDetails(String email, String password, String lastName, String firstName, Civility civility, ApplicationUserRole role) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.civility = civility;
        this.role=role;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.name());
        return Collections.singletonList(authority);
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }
}

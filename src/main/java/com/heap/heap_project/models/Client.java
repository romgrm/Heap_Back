package com.heap.heap_project.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heap.heap_project.security.auth.ApplicationUserRole;
import com.heap.heap_project.security.auth.AccountUserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends AccountUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private Address personAddress;

    /*Constructor rempli pour le test*/
    public Client(String email, String password, String lastName, String firstName, Civility civility, ApplicationUserRole applicationUserRole, Address address) {
        super(email, password, lastName, firstName, civility, applicationUserRole);
        this.personAddress = address;
    }


    public Client(String email, String password, ApplicationUserRole role) {
        super(email, password, role);
    }
}

package com.heap.heap_project.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heap.heap_project.security.auth.AccountUserDetails;
import com.heap.heap_project.security.auth.ApplicationUserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "shop")
@Getter
@Setter
@NoArgsConstructor
public class Shop extends AccountUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long siret;
    String companyName;

    @Enumerated(EnumType.STRING)
    ActivityType activityType;

    @OneToOne
    @JoinColumn(name = "store_address_id", referencedColumnName = "id")
//    @NotEmpty
    private Address shopAddress;

    @OneToOne
    @JoinColumn(name = "person_shop_address_id", referencedColumnName = "id")
//    @NotEmpty
    private  Address proAddress;

    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties("appointments")
//    @JsonManagedReference
    private List<Prestation> prestations;

    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties("appointments")
//    @JsonManagedReference
    private List<Collaborator> collaborators;

    @OneToMany(mappedBy = "shop")
    @JsonIgnoreProperties("shop")
//    @JsonIgnore
    private List<Appointment> appointments;

    public Shop(String email, String password, ApplicationUserRole role) {
        super(email, password, role);
    }
}

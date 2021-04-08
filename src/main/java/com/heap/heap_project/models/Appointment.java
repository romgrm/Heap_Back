package com.heap.heap_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="date")
    private Timestamp date;

    @Column(name="start")
    private Timestamp startingTime;

    @ManyToOne
    @JoinColumn
    // Jsonignore locale de la référence des champs de la classe fille
    @JsonIgnoreProperties("appointments")
//    @JsonBackReference
    private Prestation prestation;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("appointments")
//    @JsonBackReference
    private Collaborator collaborator;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"password","locked", "enabled",
            "role", "personAddress", "username", "authorities",
            "accountNonLocked", "credentialsNonExpired",
            "accountNonExpired", "appointments"})
//    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name="shop_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"appointments", "proAddress", "prestations","collaborators","password","siret",
            "lastName","firstName","locked","enabled","civility","role", "username","accountNonExpired",
            "credentialsNonExpired","accountNonLocked","authorities","shopAddress"})
    private Shop shop;

}

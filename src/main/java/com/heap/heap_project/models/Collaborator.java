package com.heap.heap_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "collaborator")
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name= "lastname")
    private String lastname;

    @OneToMany(mappedBy = "collaborator")
    @JsonManagedReference
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Shop shop;
}

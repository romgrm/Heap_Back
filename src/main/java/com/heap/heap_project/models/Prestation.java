package com.heap.heap_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name="prestation")
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="duration")
    private int duration;

    @Column(name="price")
    private int price;

    @OneToMany(mappedBy = "prestation")
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"appointments", "prestations", "collaborators"})
    private Shop shop;


}

package com.heap.heap_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address",
        uniqueConstraints =
        @UniqueConstraint(columnNames = {"city", "zipCode", "street", "number", "addressComplement"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String city;
    int zipCode;
    String street;
    String number;
    String addressComplement;

    @OneToOne(mappedBy = "shopAddress")
    @JsonIgnore
    // Cette annotation va permettre d'éviter d'avoir une boucle en résultat GET, sans ça ça afficherait à qui appartient cette adresse, puis l'adresse, a qui elle appartient etc
    private Shop shop;

    @OneToOne(mappedBy = "proAddress")
    @JsonIgnore
    private Shop shopPerson;

    @OneToMany(mappedBy = "personAddress")
    @JsonIgnore
    List<Client> client;

    public Address(String city, int zipCode, String street, String number, String addressComplement) {
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.number = number;
        this.addressComplement = addressComplement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", shop=" + shop +
                ", shopPerson=" + shopPerson +
                ", client=" + client +
                '}';
    }
}

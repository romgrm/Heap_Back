package com.heap.heap_project.models;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;


// Guava permet ici de coupler un Set à chaque élément de notre enum
public enum ActivityType {
    Coiffeur(Sets.newHashSet("Coupe homme", "Coupe femme")),
    Estheticienne(Sets.newHashSet("Epilation", "Soins du visage")),
    Masseur(Sets.newHashSet("Californien", "Shiatsu")),
    Spa(Sets.newHashSet("Sauna", "Hammam", "Piscine")),
    Bar_a_Ongles(Sets.newHashSet()),
    Barbier(Sets.newHashSet());


    // On initialise le set avec ses constructeur/getter associés
    private final Set<String> services;

    ActivityType(Set<String> services) {
        this.services = services;
    }

   /* On peut ainsi appeller getServices() avec chaque élément de l'enum pour obtenir son Set associé,
     ex: Coiffeur.getServices() -> [Coupe femme, Coupe homme] */
    public Set<String> getServices() {
        return services;
    }



    /*  // Return a list Set with different type created above
    public Set<String> getServiceType() {
        return getServices().stream()
                .map(item -> new String(item))
                .collect(Collectors.toSet());
    }*/
}

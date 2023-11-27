package com.example.testspring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Destination;
    private String adresse;
    @OneToOne
    private Medecin medecinGerant;

    @OneToMany(mappedBy = "clinique")
    private Set<Medecin> medecins;
}

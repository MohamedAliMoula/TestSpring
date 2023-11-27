package com.example.testspring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    public enum Specialite { CARDIOLOQUE, DENTISTE, ORTHOPEDISTE };
    public enum Poste { ACTIONNAIRE, ORDINAIRE };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String prenom;
    private Date dateEmbauche;
    private  String email;
    private String pwd;
    @Enumerated(EnumType.STRING)

    private Specialite specialite;
    @Enumerated(EnumType.STRING)

    private Poste poste;

    @OneToOne(mappedBy = "medecinGerant")
    private Clinique cliniqueGeree;

    @ManyToOne()
    private Clinique clinique;

    @ManyToMany
    private Set<Patient> patients;
}

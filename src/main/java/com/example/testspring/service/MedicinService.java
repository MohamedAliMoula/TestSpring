package com.example.testspring.service;

import com.example.testspring.Entity.Medecin;

import java.util.List;

public interface MedicinService {
    Long ajouterMedecin(Medecin medecin);
    void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId);
    void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId);
    List<String> getCardiologueMedecinNames();
    Long getNombrePatientsExaminesParMedecinPoste(Medecin.Poste poste);
}

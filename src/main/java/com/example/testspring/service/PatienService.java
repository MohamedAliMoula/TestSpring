package com.example.testspring.service;

import com.example.testspring.Entity.Patient;

public interface PatienService {
    Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin);
}

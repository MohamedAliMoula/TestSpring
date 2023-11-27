package com.example.testspring.service.Impl;

import com.example.testspring.Entity.Medecin;
import com.example.testspring.Entity.Patient;
import com.example.testspring.repo.MedecinRepository;
import com.example.testspring.repo.PatientRepository;
import com.example.testspring.service.PatienService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatienService {
    MedecinRepository medecinRepository;
    PatientRepository patientRepository;

    @Override
    public Long ajouterPatientEtAffecterAuMedecin(Patient patient, Long idMedecin) {
        Medecin medecin=medecinRepository.findMedecinById(idMedecin);
        patient.setMedecins((Set<Medecin>) medecin);
        patientRepository.save(patient);
        return patient.getId();
    }
}

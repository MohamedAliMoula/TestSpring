package com.example.testspring.service.Impl;

import com.example.testspring.Entity.Clinique;
import com.example.testspring.Entity.Medecin;
import com.example.testspring.repo.CliniqueRepository;
import com.example.testspring.repo.MedecinRepository;
import com.example.testspring.service.MedicinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedecinServiceImpl implements MedicinService {
    MedecinRepository medecinRepository;
    CliniqueRepository cliniqueRepository;
    @Override
    public Long ajouterMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
        return medecin.getId();
    }

    @Override
    public void affecterMedecinActionnaireAClinique(int medecinId, int cliniqueId) {

        Medecin medecin=medecinRepository.findMedecinById(medecinId);
        Clinique clinique=cliniqueRepository.findCliniqueById(cliniqueId);
        clinique.setMedecinGerant(medecin);;
        cliniqueRepository.save(clinique);

    }

    @Override
    public void affecterMedecinOrdinaireAClinique(int medecinId, int cliniqueId) {
        Medecin medecin=medecinRepository.findMedecinById(medecinId);
        Clinique clinique=cliniqueRepository.findCliniqueById(cliniqueId);
        Set<Medecin> ls = clinique.getMedecins();
        ls.add(medecin);
        clinique.setMedecins(ls);

        cliniqueRepository.save(clinique);
    }

    @Override
    public List<String> getCardiologueMedecinNames() {
        return medecinRepository.findAll().stream()
                .filter(m -> m.getSpecialite() == Medecin.Specialite.CARDIOLOQUE)
                .map(Medecin::getNom)
                .collect(Collectors.toList());
    }

    @Override
    public Long getNombrePatientsExaminesParMedecinPoste(Medecin.Poste poste) {

        long nb= medecinRepository.findAll().stream()
                .filter(m -> Objects.equals(m.getPoste().toString(), poste.toString()))
                .findFirst()
                .get().getPatients().size();
        return  nb;
    }
}

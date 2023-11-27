package com.example.testspring.service.Impl;

import com.example.testspring.Entity.Clinique;
import com.example.testspring.repo.CliniqueRepository;
import com.example.testspring.service.CliniqueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CliniqueServiceImpl implements CliniqueService {
    CliniqueRepository cliniqueRepository;
    @Override
    public Long ajouterClinique(Clinique clinique) {
         cliniqueRepository.save(clinique);
        return clinique.getId();
    }
}

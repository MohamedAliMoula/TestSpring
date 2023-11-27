package com.example.testspring.Controller;

import com.example.testspring.Entity.Clinique;
import com.example.testspring.Entity.Medecin;
import com.example.testspring.Entity.Patient;
import com.example.testspring.service.CliniqueService;
import com.example.testspring.service.MedicinService;
import com.example.testspring.service.PatienService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/blocs")
@CrossOrigin("*")
public class Controller {
    MedicinService medicinService;
    CliniqueService cliniqueService;
    PatienService patienService;

    @PostMapping("/addclinique")
    public Long addclinique(@RequestBody Clinique e) {
        return cliniqueService.ajouterClinique(e);
    }
    @PostMapping("/ajoutermedecin")
    public Long addmedicin(@RequestBody Medecin o){
        return medicinService.ajouterMedecin(o);
    }

    @PutMapping("affectermedecingererclinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinActionnaireAClinique(@PathVariable int medecinId, @PathVariable int cliniqueId) {
        medicinService.affecterMedecinActionnaireAClinique(medecinId, cliniqueId);
    }

    @PutMapping("affectermedecinordinaireclinique/{medecinId}/{cliniqueId}")
    public void affecterMedecinOrdinaireAClinique(@PathVariable int medecinId, @PathVariable int cliniqueId) {
        medicinService.affecterMedecinOrdinaireAClinique(medecinId, cliniqueId);
    }

    @PutMapping("ajouterpatientaffectermedecin/{idMedecin}")
    public long ajouterPatientEtAffecterAuMedecin(@RequestBody Patient patient, @PathVariable long idMedecin) {
        return patienService.ajouterPatientEtAffecterAuMedecin(patient, idMedecin);
    }

    @GetMapping("cardiologuemedecinnames")
    public List<String> getCardiologueMedecinNames() {
        return medicinService.getCardiologueMedecinNames();
    }

    @GetMapping("NombrePatientsExaminesParMedecinPoste")
    public long getNombrePatientsExaminesParMedecinPoste(@RequestParam Medecin.Poste poste) {
        return medicinService.getNombrePatientsExaminesParMedecinPoste(poste);
    }
}

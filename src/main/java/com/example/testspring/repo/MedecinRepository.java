package com.example.testspring.repo;

import com.example.testspring.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findMedecinById(long id );
//    @Modifying
//    @Query("select '*' from Medecin where Medecin.poste= 'CARDIOLOGUE' ")
//    List<String> getAll();

}

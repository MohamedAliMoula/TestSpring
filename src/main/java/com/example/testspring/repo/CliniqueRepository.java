package com.example.testspring.repo;

import com.example.testspring.Entity.Clinique;

import com.example.testspring.Entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CliniqueRepository extends JpaRepository<Clinique,Long> {
    Clinique findCliniqueById(long id );

}

package com.gestion.etudiants.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.etudiants.entites.FiliereEntite;

@Repository
public interface FiliereRepository extends JpaRepository<FiliereEntite, Integer>{

}

package com.gestion.etudiants.repositories;

import com.gestion.etudiants.entites.MatiereEntite;
import com.gestion.etudiants.entites.ModuleEntite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<MatiereEntite, Integer> {

}

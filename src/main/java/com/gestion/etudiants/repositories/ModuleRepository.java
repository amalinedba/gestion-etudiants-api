package com.gestion.etudiants.repositories;

import com.gestion.etudiants.entites.ModuleEntite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<ModuleEntite, Integer> {

}

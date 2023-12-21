package com.gestion.etudiants.services;

import java.util.List;
import java.util.function.LongFunction;

import com.gestion.etudiants.controller.dto.FiliereDTO;

public interface FiliereService {
	List<FiliereDTO> getAllFilieres();
	FiliereDTO addFiliere(FiliereDTO filiereDTO);
	FiliereDTO updateFiliere(Integer id, FiliereDTO filiereDTO);
}

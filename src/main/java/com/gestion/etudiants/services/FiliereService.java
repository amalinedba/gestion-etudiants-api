package com.gestion.etudiants.services;

import java.util.List;

import com.gestion.etudiants.controller.dto.FiliereDTO;

public interface FiliereService {
	List<FiliereDTO> getAllFilieres();
	FiliereDTO addFiliere(FiliereDTO filiereDTO);

}

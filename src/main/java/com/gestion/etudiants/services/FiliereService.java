package com.gestion.etudiants.services;

import java.util.List;
import java.util.function.LongFunction;

import com.gestion.etudiants.controller.dto.FiliereDTO;
import exception.FiliereNotFoundException;

public interface FiliereService {
	List<FiliereDTO> getAllFilieres();

	FiliereDTO getFiliere(int idFiliere) throws FiliereNotFoundException;

	FiliereDTO addFiliere(FiliereDTO filiereDTO);

	FiliereDTO updateFiliere(Integer id, FiliereDTO filiereDTO) throws FiliereNotFoundException;
}

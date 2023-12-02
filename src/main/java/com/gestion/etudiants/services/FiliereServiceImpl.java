package com.gestion.etudiants.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etudiants.controller.dto.FiliereDTO;
import com.gestion.etudiants.entites.FiliereEntite;
import com.gestion.etudiants.repositories.FiliereRepository;

@Service
public class FiliereServiceImpl implements FiliereService{
	
	@Autowired
	private FiliereRepository filiereRepository;
	

	@Override
	public List<FiliereDTO> getAllFilieres() {
		List<FiliereEntite> filieres= filiereRepository.findAll();
		return filieres.stream()
				.map(f->convertirEnFiliereDto(f))
				.collect(Collectors.toList());
	}
	
	private FiliereDTO convertirEnFiliereDto(FiliereEntite entite) {
		FiliereDTO filiereDTO = new FiliereDTO();
		filiereDTO.setIdentifiantFiliere(entite.getIdFiliere());
		filiereDTO.setDescriptionFiliere(entite.getDescription());
		filiereDTO.setNomFiliere(entite.getNom());
		return filiereDTO;
	}
	
	private FiliereEntite convertirEnFiliereEntite(FiliereDTO filiereDTO) {
		FiliereEntite entite = new FiliereEntite();
		entite.setIdFiliere(filiereDTO.getIdentifiantFiliere());
		entite.setDescription(filiereDTO.getDescriptionFiliere());
		entite.setNom(filiereDTO.getNomFiliere());
		return entite;
	}

	@Override
	public FiliereDTO addFiliere(FiliereDTO filiereDTO) {
		FiliereEntite filiereEntite = convertirEnFiliereEntite(filiereDTO);
		filiereRepository.save(filiereEntite);
		return convertirEnFiliereDto(filiereEntite);
	}

}

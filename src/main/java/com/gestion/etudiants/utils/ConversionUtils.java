package com.gestion.etudiants.utils;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.gestion.etudiants.controller.dto.FiliereDTO;
import com.gestion.etudiants.controller.dto.MatiereDTO;
import com.gestion.etudiants.controller.dto.ModuleDTO;
import com.gestion.etudiants.entites.FiliereEntite;
import com.gestion.etudiants.entites.MatiereEntite;
import com.gestion.etudiants.entites.ModuleEntite;

public class ConversionUtils {
	
	public static FiliereDTO convertirEnFiliereDto(FiliereEntite entite) {
		FiliereDTO filiereDTO = new FiliereDTO();
		filiereDTO.setIdentifiantFiliere(entite.getIdFiliere());
		filiereDTO.setDescriptionFiliere(entite.getDescription());
		filiereDTO.setNomFiliere(entite.getNom());
		return filiereDTO;
	}
	
	public static FiliereEntite convertirEnFiliereEntite(FiliereDTO filiereDTO) {
		FiliereEntite entite = new FiliereEntite();
		entite.setIdFiliere(filiereDTO.getIdentifiantFiliere());
		entite.setDescription(filiereDTO.getDescriptionFiliere());
		entite.setNom(filiereDTO.getNomFiliere());
		entite.setModules(filiereDTO.getModules()
				.stream()
				.map(module->convertirEnModuleEntite(module))
				.collect(Collectors.toSet()));
		return entite;
	}
	
	public static MatiereEntite convertirEnMatiereEntite(MatiereDTO matiereDTO) {
		MatiereEntite matiereEntite = new MatiereEntite();
		matiereEntite.setNom(matiereDTO.getLibelle());
		return matiereEntite;
	}
	
	public static ModuleEntite convertirEnModuleEntite(ModuleDTO moduleDTO) {
		ModuleEntite moduleEntite = new ModuleEntite();
		moduleEntite.setNom(moduleDTO.getLibelle());
		moduleEntite.setMatieres(moduleDTO.getMatieres().stream()
				.map(matiere->convertirEnMatiereEntite(matiere))
				.collect(Collectors.toSet()));
		return moduleEntite;
	}

}

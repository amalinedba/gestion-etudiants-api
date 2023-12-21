package com.gestion.etudiants.services;

import java.util.*;
import java.util.stream.Collectors;

import com.gestion.etudiants.controller.dto.MatiereDTO;
import com.gestion.etudiants.entites.MatiereEntite;
import com.gestion.etudiants.entites.ModuleEntite;
import com.gestion.etudiants.repositories.ModuleRepository;
import exception.FiliereNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.etudiants.controller.dto.FiliereDTO;
import com.gestion.etudiants.controller.dto.ModuleDTO;
import com.gestion.etudiants.entites.FiliereEntite;
import com.gestion.etudiants.repositories.FiliereRepository;
import com.gestion.etudiants.utils.ConversionUtils;

@Service
public class FiliereServiceImpl implements FiliereService{
	
	@Autowired
	private FiliereRepository filiereRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	

	@Override
	public List<FiliereDTO> getAllFilieres() {
		List<FiliereEntite> filieres = filiereRepository.findAll();

		return filieres.stream()
				.map(f->ConversionUtils.convertirEnFiliereDto(f))
				.collect(Collectors.toList());
	}

	@Override
	public FiliereDTO getFiliere(int idFiliere) throws FiliereNotFoundException {
		Optional<FiliereEntite> filiereOptional = filiereRepository.findById(idFiliere);

		if (filiereOptional.isEmpty()) {
			throw new FiliereNotFoundException("Filière inexistante");
		}

		return ConversionUtils.convertirEnFiliereDto(filiereOptional.get());
	}

	@Override
	public FiliereDTO addFiliere(FiliereDTO filiereDTO) {
		FiliereEntite filiereEntite = ConversionUtils.convertirEnFiliereEntite(filiereDTO);
		// relier les fils au pere pour la sauvegarde cascade
		filiereEntite.getModules().forEach(module->{
			module.setFiliere(filiereEntite);
			module.getMatieres().forEach(matiere->{
				matiere.setModule(module);
			});
		});
		
		filiereRepository.save(filiereEntite);
		return ConversionUtils.convertirEnFiliereDto(filiereEntite);
	}

	@Override
	public FiliereDTO updateFiliere(Integer id, FiliereDTO filiereDTO) throws FiliereNotFoundException {
		Optional<FiliereEntite> filiereOptional = filiereRepository.findById(id);

		if (filiereOptional.isEmpty()) {
			throw new FiliereNotFoundException("Filière inexistante");
		}

		FiliereEntite nouvelleFiliere = ConversionUtils.convertirEnFiliereEntite(filiereDTO);

		nouvelleFiliere.setIdFiliere(id);

		nouvelleFiliere.getModules().forEach(module->{
			module.setFiliere(nouvelleFiliere);
			module.getMatieres().forEach(matiere->{
				matiere.setModule(module);
			});
		});

		filiereRepository.save(nouvelleFiliere);
		return ConversionUtils.convertirEnFiliereDto(nouvelleFiliere);
	}
}

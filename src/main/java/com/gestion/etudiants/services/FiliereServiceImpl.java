package com.gestion.etudiants.services;

import java.util.List;
import java.util.stream.Collectors;

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
	

	@Override
	public List<FiliereDTO> getAllFilieres() {
		List<FiliereEntite> filieres= filiereRepository.findAll();
		return filieres.stream()
				.map(f->ConversionUtils.convertirEnFiliereDto(f))
				.collect(Collectors.toList());
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

}

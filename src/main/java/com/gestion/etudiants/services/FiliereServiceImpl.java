package com.gestion.etudiants.services;

import java.util.*;
import java.util.stream.Collectors;

import com.gestion.etudiants.controller.dto.MatiereDTO;
import com.gestion.etudiants.entites.MatiereEntite;
import com.gestion.etudiants.entites.ModuleEntite;
import com.gestion.etudiants.repositories.ModuleRepository;
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
		List<FiliereDTO> filiereDTOs = new ArrayList<>();

		/*return filieres.stream()
				.map(f->ConversionUtils.convertirEnFiliereDto(f))
				.collect(Collectors.toList());*/

		for (FiliereEntite f : filieres) {
			FiliereDTO filiereDTO = ConversionUtils.convertirEnFiliereDto(f);
			List<ModuleDTO> moduleDTOs = new ArrayList<>();

			for (ModuleEntite m : f.getModules()) {
				ModuleDTO moduleDTO = ConversionUtils.convertirEnModuleDto(m);
				List<MatiereDTO> matiereDTOs = new ArrayList<>();

				for (MatiereEntite matiere : m.getMatieres()) {
					MatiereDTO matiereDTO = ConversionUtils.convertirEnMatiereDto(matiere);
					matiereDTOs.add(matiereDTO);
				}

				moduleDTO.setMatieres(matiereDTOs);
				moduleDTOs.add(moduleDTO);
			}

			filiereDTO.setModules(moduleDTOs);
			filiereDTOs.add(filiereDTO);
		}

		return filiereDTOs;
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
	public FiliereDTO updateFiliere(Integer id, FiliereDTO filiereDTO) {
		Optional<FiliereEntite> filiereOptional = filiereRepository.findById(id);

		if (filiereOptional.isPresent()) {
			FiliereEntite filiereEntite = filiereOptional.get();

			filiereEntite.setNom(filiereDTO.getNomFiliere());
			filiereEntite.setDescription(filiereDTO.getDescriptionFiliere());

			// Partie pour mettre à jour les modules et filières: ça passe pas
			/*List<ModuleDTO> nouveauxModules = filiereDTO.getModules();
			for (ModuleDTO nouveauModule : nouveauxModules) {
				// System.out.println("Affiche: " + nouveauxModules);
				ModuleEntite moduleEntite = filiereEntite.getModules().stream()
						.filter(m -> Objects.equals(m.getIdModule(), nouveauModule.getIdentifiantModule()))
						.findFirst()
						.orElseThrow();

				moduleEntite.setNom(nouveauModule.getLibelle());
				System.out.println("Mod Entite: " + moduleEntite.getNom());
				System.out.println("Mod Dto: " + nouveauModule.getLibelle());

				List<MatiereDTO> nouvellesMatieres = nouveauModule.getMatieres();
				for (MatiereDTO nouvelleMatiere : nouvellesMatieres) {
					MatiereEntite matiereEntite = moduleEntite.getMatieres().stream()
							.filter(mat -> Objects.equals(mat.getIdMatiere(), nouvelleMatiere.getIdentifiantMatiere()))
							.findFirst()
							.orElseThrow();

					matiereEntite.setNom(nouvelleMatiere.getLibelle());
				}
			}*/

			filiereRepository.save(filiereEntite);
			return ConversionUtils.convertirEnFiliereDto(filiereEntite);
		}
		return null;
	}
}

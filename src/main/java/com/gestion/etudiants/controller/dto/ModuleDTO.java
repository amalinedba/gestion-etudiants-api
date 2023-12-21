package com.gestion.etudiants.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
	private int identifiantModule;
	private String libelle;
	private List<MatiereDTO> matieres;

	@Override
	public String toString() {
		return "ModuleDTO [identifiantModule=" + identifiantModule + ", libelle=" + libelle + ", matieres=" + matieres
				+ "]";
	}
	
	
	
}

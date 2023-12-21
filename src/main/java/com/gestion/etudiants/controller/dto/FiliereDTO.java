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
public class FiliereDTO {
	private int identifiantFiliere;
	private String nomFiliere;
	private String descriptionFiliere;
	private List<ModuleDTO> modules;

	@Override
	public String toString() {
		return "FiliereDTO [identifiantFiliere=" + identifiantFiliere + ", nomFiliere=" + nomFiliere
				+ ", descriptionFiliere=" + descriptionFiliere + ", modules=" + modules + "]";
	}
	
	
}

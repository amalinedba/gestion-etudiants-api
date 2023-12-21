package com.gestion.etudiants.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatiereDTO {
	private int identifiantMatiere;
	private String libelle;

	@Override
	public String toString() {
		return "MatiereDTO [identifiantMatiere=" + identifiantMatiere + ", libelle=" + libelle + "]";
	}
	
	
	

}

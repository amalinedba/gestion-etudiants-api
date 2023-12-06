package com.gestion.etudiants.controller.dto;

import java.util.List;

public class FiliereDTO {
	private int identifiantFiliere;
	private String nomFiliere;
	private String descriptionFiliere;
	private List<ModuleDTO> modules;
	
	public FiliereDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdentifiantFiliere() {
		return identifiantFiliere;
	}
	public void setIdentifiantFiliere(int identifiantFiliere) {
		this.identifiantFiliere = identifiantFiliere;
	}
	public String getNomFiliere() {
		return nomFiliere;
	}
	public void setNomFiliere(String nomFiliere) {
		this.nomFiliere = nomFiliere;
	}
	public String getDescriptionFiliere() {
		return descriptionFiliere;
	}
	public void setDescriptionFiliere(String descriptionFiliere) {
		this.descriptionFiliere = descriptionFiliere;
	}
	public List<ModuleDTO> getModules() {
		return modules;
	}
	public void setModules(List<ModuleDTO> modules) {
		this.modules = modules;
	}
	@Override
	public String toString() {
		return "FiliereDTO [identifiantFiliere=" + identifiantFiliere + ", nomFiliere=" + nomFiliere
				+ ", descriptionFiliere=" + descriptionFiliere + ", modules=" + modules + "]";
	}
	
	
}

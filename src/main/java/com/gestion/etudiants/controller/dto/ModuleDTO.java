package com.gestion.etudiants.controller.dto;

import java.util.List;

public class ModuleDTO {
	private int identifiantModule;
	private String libelle;
	private List<MatiereDTO> matieres;
	
	
	public ModuleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdentifiantModule() {
		return identifiantModule;
	}
	public void setIdentifiantModule(int identifiantModule) {
		this.identifiantModule = identifiantModule;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<MatiereDTO> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<MatiereDTO> matieres) {
		this.matieres = matieres;
	}
	@Override
	public String toString() {
		return "ModuleDTO [identifiantModule=" + identifiantModule + ", libelle=" + libelle + ", matieres=" + matieres
				+ "]";
	}
	
	
	
}

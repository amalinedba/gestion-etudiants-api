package com.gestion.etudiants.controller.dto;

public class FiliereDTO {
	private int identifiantFiliere;
	private String nomFiliere;
	private String descriptionFiliere;
	
	
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
	
	

}

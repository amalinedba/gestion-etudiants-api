package com.gestion.etudiants.controller.dto;

public class MatiereDTO {
	private int identifiantMatiere;
	private String libelle;
	public MatiereDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdentifiantMatiere() {
		return identifiantMatiere;
	}
	public void setIdentifiantMatiere(int identifiantMatiere) {
		this.identifiantMatiere = identifiantMatiere;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "MatiereDTO [identifiantMatiere=" + identifiantMatiere + ", libelle=" + libelle + "]";
	}
	
	
	

}

package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@Table(name = "matiere")
@NamedQuery(name="MatiereEntite.findAll", query="SELECT m FROM MatiereEntite m")
public class MatiereEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_matiere")
	private int idMatiere;

	private String nom;

	@Column(name="volume_horaire")
	private int volumeHoraire;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="id_module")
	private ModuleEntite module;

	public MatiereEntite() {
	}

	public int getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVolumeHoraire() {
		return this.volumeHoraire;
	}

	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}

	public ModuleEntite getModule() {
		return this.module;
	}

	public void setModule(ModuleEntite module) {
		this.module = module;
	}

}
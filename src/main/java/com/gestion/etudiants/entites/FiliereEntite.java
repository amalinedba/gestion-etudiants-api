package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the filiere database table.
 * 
 */
@Entity
@Table(name = "filiere")
@NamedQuery(name="FiliereEntite.findAll", query="SELECT f FROM FiliereEntite f")
public class FiliereEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_filiere")
	private int idFiliere;

	@Lob
	private String description;

	private int duree;

	private String nom;

	//bi-directional many-to-one association to Module
	@OneToMany(mappedBy="filiere", cascade = CascadeType.ALL)
	private Set<ModuleEntite> modules;

	//bi-directional many-to-one association to Niveau
	@OneToMany(mappedBy="filiere")
	private Set<NiveauEntite> niveaus;

	public FiliereEntite() {
	}

	public int getIdFiliere() {
		return this.idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<ModuleEntite> getModules() {
		return this.modules;
	}

	public void setModules(Set<ModuleEntite> modules) {
		this.modules = modules;
	}

	public ModuleEntite addModule(ModuleEntite module) {
		getModules().add(module);
		module.setFiliere(this);

		return module;
	}

	public ModuleEntite removeModule(ModuleEntite module) {
		getModules().remove(module);
		module.setFiliere(null);

		return module;
	}

	public Set<NiveauEntite> getNiveaus() {
		return this.niveaus;
	}

	public void setNiveaus(Set<NiveauEntite> niveaus) {
		this.niveaus = niveaus;
	}

	public NiveauEntite addNiveaus(NiveauEntite niveaus) {
		getNiveaus().add(niveaus);
		niveaus.setFiliere(this);

		return niveaus;
	}

	public NiveauEntite removeNiveaus(NiveauEntite niveaus) {
		getNiveaus().remove(niveaus);
		niveaus.setFiliere(null);

		return niveaus;
	}

}
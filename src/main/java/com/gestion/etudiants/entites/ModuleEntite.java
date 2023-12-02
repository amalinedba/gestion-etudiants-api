package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name = "module")
@NamedQuery(name="ModuleEntite.findAll", query="SELECT m FROM ModuleEntite m")
public class ModuleEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_module")
	private int idModule;

	private String nom;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="module")
	private Set<MatiereEntite> matieres;

	//bi-directional many-to-one association to Filiere
	@ManyToOne
	@JoinColumn(name="id_filiere")
	private FiliereEntite filiere;

	public ModuleEntite() {
	}

	public int getIdModule() {
		return this.idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<MatiereEntite> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(Set<MatiereEntite> matieres) {
		this.matieres = matieres;
	}

	public MatiereEntite addMatiere(MatiereEntite matiere) {
		getMatieres().add(matiere);
		matiere.setModule(this);

		return matiere;
	}

	public MatiereEntite removeMatiere(MatiereEntite matiere) {
		getMatieres().remove(matiere);
		matiere.setModule(null);

		return matiere;
	}

	public FiliereEntite getFiliere() {
		return this.filiere;
	}

	public void setFiliere(FiliereEntite filiere) {
		this.filiere = filiere;
	}

}
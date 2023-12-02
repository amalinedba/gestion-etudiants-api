package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the niveau database table.
 * 
 */
@Entity
@Table(name = "niveau")
@NamedQuery(name="NiveauEntite.findAll", query="SELECT n FROM NiveauEntite n")
public class NiveauEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_niveau")
	private int idNiveau;

	private String libelle;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="niveau")
	private Set<InscriptionEntite> inscriptions;

	//bi-directional many-to-one association to Filiere
	@ManyToOne
	@JoinColumn(name="id_filiere")
	private FiliereEntite filiere;

	public NiveauEntite() {
	}

	public int getIdNiveau() {
		return this.idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<InscriptionEntite> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<InscriptionEntite> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public InscriptionEntite addInscription(InscriptionEntite inscription) {
		getInscriptions().add(inscription);
		inscription.setNiveau(this);

		return inscription;
	}

	public InscriptionEntite removeInscription(InscriptionEntite inscription) {
		getInscriptions().remove(inscription);
		inscription.setNiveau(null);

		return inscription;
	}

	public FiliereEntite getFiliere() {
		return this.filiere;
	}

	public void setFiliere(FiliereEntite filiere) {
		this.filiere = filiere;
	}

}
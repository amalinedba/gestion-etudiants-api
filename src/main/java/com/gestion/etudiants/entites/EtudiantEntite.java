package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@Table(name = "etudiant")
@NamedQuery(name="EtudiantEntite.findAll", query="SELECT e FROM EtudiantEntite e")
@NoArgsConstructor
@Getter
@Setter
public class EtudiantEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_etudiant")
	private int idEtudiant;

	private String adresse;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	private String matricule;

	private String nom;

	private String prenom;

	private String sexe;

	private String telephone;

	//bi-directional many-to-one association to Diplome
	@OneToMany(mappedBy="etudiant")
	private Set<DiplomeEntite> diplomes;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="etudiant")
	private Set<InscriptionEntite> inscriptions;

	public DiplomeEntite addDiplome(DiplomeEntite diplome) {
		getDiplomes().add(diplome);
		diplome.setEtudiant(this);

		return diplome;
	}

	public DiplomeEntite removeDiplome(DiplomeEntite diplome) {
		getDiplomes().remove(diplome);
		diplome.setEtudiant(null);

		return diplome;
	}

	public Set<InscriptionEntite> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<InscriptionEntite> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public InscriptionEntite addInscription(InscriptionEntite inscription) {
		getInscriptions().add(inscription);
		inscription.setEtudiant(this);

		return inscription;
	}

	public InscriptionEntite removeInscription(InscriptionEntite inscription) {
		getInscriptions().remove(inscription);
		inscription.setEtudiant(null);

		return inscription;
	}

}
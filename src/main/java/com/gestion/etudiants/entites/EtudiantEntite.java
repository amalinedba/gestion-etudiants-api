package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the etudiant database table.
 * 
 */
@Entity
@Table(name = "etudiant")
@NamedQuery(name="EtudiantEntite.findAll", query="SELECT e FROM EtudiantEntite e")
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

	public EtudiantEntite() {
	}

	public int getIdEtudiant() {
		return this.idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<DiplomeEntite> getDiplomes() {
		return this.diplomes;
	}

	public void setDiplomes(Set<DiplomeEntite> diplomes) {
		this.diplomes = diplomes;
	}

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
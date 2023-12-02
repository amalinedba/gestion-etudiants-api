package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the diplome database table.
 * 
 */
@Entity
@Table(name = "diplome")
@NamedQuery(name="DiplomeEntite.findAll", query="SELECT d FROM DiplomeEntite d")
public class DiplomeEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_diplome")
	private int idDiplome;

	@Temporal(TemporalType.DATE)
	@Column(name="date_obtention")
	private Date dateObtention;

	private String niveau;

	private String nom;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="id_etudiant")
	private EtudiantEntite etudiant;

	public DiplomeEntite() {
	}

	public int getIdDiplome() {
		return this.idDiplome;
	}

	public void setIdDiplome(int idDiplome) {
		this.idDiplome = idDiplome;
	}

	public Date getDateObtention() {
		return this.dateObtention;
	}

	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public EtudiantEntite getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(EtudiantEntite etudiant) {
		this.etudiant = etudiant;
	}

}
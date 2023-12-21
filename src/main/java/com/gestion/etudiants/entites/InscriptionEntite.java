package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the inscription database table.
 * 
 */
@Entity
@Table(name = "inscription")
@NamedQuery(name="InscriptionEntite.findAll", query="SELECT i FROM InscriptionEntite i")
@NoArgsConstructor
@Getter
@Setter
public class InscriptionEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inscription")
	private int idInscription;

	@Temporal(TemporalType.DATE)
	@Column(name="date_inscription")
	private Date dateInscription;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="id_etudiant")
	private EtudiantEntite etudiant;

	//bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name="id_niveau")
	private NiveauEntite niveau;

}
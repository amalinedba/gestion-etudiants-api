package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


/**
 * The persistent class for the diplome database table.
 * 
 */
@Entity
@Table(name = "diplome")
@NamedQuery(name="DiplomeEntite.findAll", query="SELECT d FROM DiplomeEntite d")
@NoArgsConstructor
@Getter
@Setter
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

}
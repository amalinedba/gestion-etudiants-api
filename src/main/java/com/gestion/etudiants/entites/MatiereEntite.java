package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
@Table(name = "matiere")
@NamedQuery(name="MatiereEntite.findAll", query="SELECT m FROM MatiereEntite m")
@NoArgsConstructor
@Getter
@Setter
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

}
package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the filiere database table.
 * 
 */
@Entity
@Table(name = "filiere")
@NamedQuery(name="FiliereEntite.findAll", query="SELECT f FROM FiliereEntite f")
@NoArgsConstructor
@Getter
@Setter
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
	@OneToMany(mappedBy="filiere", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<ModuleEntite> modules;

	//bi-directional many-to-one association to Niveau
	@OneToMany(mappedBy="filiere")
	private Set<NiveauEntite> niveaus;

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
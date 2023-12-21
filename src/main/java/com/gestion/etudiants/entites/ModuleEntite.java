package com.gestion.etudiants.entites;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
@Table(name = "module")
@NamedQuery(name="ModuleEntite.findAll", query="SELECT m FROM ModuleEntite m")
@NoArgsConstructor
@Getter
@Setter
public class ModuleEntite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_module")
	private int idModule;

	private String nom;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="module", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<MatiereEntite> matieres;

	//bi-directional many-to-one association to Filiere
	@ManyToOne
	@JoinColumn(name="id_filiere")
	private FiliereEntite filiere;

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

	/*public MatiereEntite updateMatiere(MatiereEntite matiere) {
		MatiereEntite matiereExistante = findMatiereById(matiere.getIdMatiere());

		if (matiereExistante != null) {
			List<MatiereEntite> matieres = getMatieres();
			int index = matieres.indexOf(matiereExistante);

			if (index != -1) {
				matieres.set(index, matiere);
				matiere.setModule(this);

				return matiereExistante;
			}
		}
		return null;
	}

	// Méthode pour avoir l'ID de la matière
	private MatiereEntite findMatiereById(int matiereId) {
		for (MatiereEntite matiere : matieres) {
			if (matiere.getIdMatiere() == matiereId) {
				return matiere;
			}
		}
		return null; // si la matière n'est pas trouvée
	}*/

	public FiliereEntite getFiliere() {
		return this.filiere;
	}

	public void setFiliere(FiliereEntite filiere) {
		this.filiere = filiere;
	}

}
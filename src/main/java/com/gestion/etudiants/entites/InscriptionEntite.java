package com.gestion.etudiants.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "inscription")

public class InscriptionEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private EtudiantEntite etudiant;

    @ManyToOne
    @JoinColumn(name = "filiere_id", nullable = false)
    private FiliereEntite filiere;

    private LocalDate dateInscription;


    // Constructeur avec paramètres
    public InscriptionEntite(EtudiantEntite etudiant, FiliereEntite filiere, LocalDate dateInscription) {
        this.etudiant = etudiant;
        this.filiere = filiere;
        this.dateInscription = dateInscription;
    }

    public InscriptionEntite() {

    }

    // Vous pouvez ajouter d'autres méthodes si nécessaire

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", etudiant=" + etudiant +
                ", filiere=" + filiere +
                ", dateInscription=" + dateInscription +
                '}';
    }
}

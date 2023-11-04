package com.gestion.etudiants.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "filiere")
public class FiliereEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomFiliere;

    @OneToMany(mappedBy = "filiere")
    private List<EtudiantEntite> etudiants;

    // Constructeur par défaut
    public FiliereEntite() {
        // Constructeur par défaut
    }

    // Constructeur avec paramètres
    public FiliereEntite(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    // Getters and Setters

    // Vous pouvez ajouter d'autres getters et setters si nécessaire

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", nomFiliere='" + nomFiliere + '\'' +
                '}';
    }
}

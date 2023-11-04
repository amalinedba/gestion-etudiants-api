package com.gestion.etudiants.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "matiere")
public class MatiereEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMatiere;

    @OneToMany(mappedBy = "matiere")
    private List<EtudiantEntite> etudiants;

    // Constructeur par défaut
    public MatiereEntite() {
        // Constructeur par défaut
    }

    // Constructeur avec paramètres
    public MatiereEntite(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    // Getters and Setters

    // Vous pouvez ajouter d'autres getters et setters si nécessaire

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", nomMatiere='" + nomMatiere + '\'' +
                '}';
    }
}

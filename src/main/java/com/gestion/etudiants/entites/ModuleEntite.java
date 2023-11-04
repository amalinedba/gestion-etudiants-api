package com.gestion.etudiants.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "module")
public class ModuleEntite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomModule;

    @OneToMany(mappedBy = "module")
    private List<EtudiantEntite> etudiants;

    // Constructeur par défaut
    public ModuleEntite() {
        // Constructeur par défaut
    }

    // Constructeur avec paramètres
    public ModuleEntite(String nomModule) {
        this.nomModule = nomModule;
    }

    // Getters and Setters

    // Vous pouvez ajouter d'autres getters et setters si nécessaire

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", nomModule='" + nomModule + '\'' +
                '}';
    }
}

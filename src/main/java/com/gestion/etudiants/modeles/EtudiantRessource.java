package com.gestion.etudiants.modeles;

import java.util.Objects;
/**
 * Etudiant
 */


public class EtudiantRessource {
  private Integer id = null;

  private String nom = null;

  private String prenom = null;

  private String dateDeNaissance = null;

  public EtudiantRessource id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EtudiantRessource nom(String nom) {
    this.nom = nom;
    return this;
  }

   /**
   * Get nom
   * @return nom
  **/
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public EtudiantRessource prenom(String prenom) {
    this.prenom = prenom;
    return this;
  }

   /**
   * Get prenom
   * @return prenom
  **/
  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public EtudiantRessource dateDeNaissance(String dateDeNaissance) {
    this.dateDeNaissance = dateDeNaissance;
    return this;
  }

   /**
   * Get dateDeNaissance
   * @return dateDeNaissance
  **/
  public String getDateDeNaissance() {
    return dateDeNaissance;
  }

  public void setDateDeNaissance(String dateDeNaissance) {
    this.dateDeNaissance = dateDeNaissance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EtudiantRessource etudiant = (EtudiantRessource) o;
    return Objects.equals(this.id, etudiant.id) &&
        Objects.equals(this.nom, etudiant.nom) &&
        Objects.equals(this.prenom, etudiant.prenom) &&
        Objects.equals(this.dateDeNaissance, etudiant.dateDeNaissance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nom, prenom, dateDeNaissance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Etudiant {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nom: ").append(toIndentedString(nom)).append("\n");
    sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
    sb.append("    dateDeNaissance: ").append(toIndentedString(dateDeNaissance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

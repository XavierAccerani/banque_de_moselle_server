package fr.florian.demo.form;

import javax.validation.constraints.NotEmpty;

public class UtilisateurForm {

    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    /**
     * Difficulté ici : comment gérer le ManyToMany au niveau du formulaire ?
     * Le seul cas problématique est la séparation du Rédacteur et du Réceptionnaire...
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}

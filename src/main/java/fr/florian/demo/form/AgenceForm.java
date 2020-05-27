package fr.florian.demo.form;

import javax.validation.constraints.NotEmpty;

public class AgenceForm {
    @NotEmpty
    private String nom;
    @NotEmpty
    private String adresse;
    @NotEmpty
    private String typeAgence;

    public String getNom() {
        return nom;
    }

    public void setNom(final String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(final String adresse) {
        this.adresse = adresse;
    }

    // never used??
    public String getTypeAgence() {
        return typeAgence;
    }

    public void setTypeAgence(final String typeAgence) {
        this.typeAgence = typeAgence;
    }
}

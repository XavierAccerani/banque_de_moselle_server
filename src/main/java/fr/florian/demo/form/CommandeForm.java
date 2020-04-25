package fr.florian.demo.form;

import fr.florian.demo.modele.Fournisseur;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommandeForm {
    @NotEmpty
    private String numero;
    @NotNull
    private Fournisseur fournisseur;

    public String getNumero() {
        return numero;
    }

    public void setNumero(final String numero) {
        this.numero = numero;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(final Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}

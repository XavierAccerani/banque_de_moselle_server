package fr.florian.demo.modele;

import javax.persistence.*;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numero;

    @ManyToOne
    @JoinColumn
    private Fournisseur fournisseur;

    public Commande() {
    }

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

package fr.florian.demo.modele;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    @ManyToOne
    @JoinColumn
    private Fournisseur fournisseur;

    /**
     * Ajout d'une jointure entre les deux tables
     * Une commande concerne une seule agence
     */
    @ManyToOne
    @JoinColumn
    private Agence agence;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LigneCommande> lignesCommandes;

    public Commande() {
        lignesCommandes = new ArrayList<>();
    }

    public Long getId() {
        return id;
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

    public List<LigneCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(final List<LigneCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }
}


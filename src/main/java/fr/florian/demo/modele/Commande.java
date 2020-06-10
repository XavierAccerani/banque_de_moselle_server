package fr.florian.demo.modele;

import fr.florian.demo.modele.etat.EtatCommande;

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

    @Column
    private EtatCommande etat;

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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public String getDescriptifEtat() {
        return descriptifEtat;
    }

    public void setDescriptifEtat(String etatActuel) {
        this.descriptifEtat = etatActuel;
    }

    // Méthodes de la classe Commande liées au design pattern State
    public void creer() {
        etat.creer(this);
    }

    public void rediger() {
        etat.rediger(this);
    }

    public void viser() {
        etat.viser(this);
    }

    public void signer() {
        etat.signer(this);
    }

    public void envoyer() {
        etat.signer(this);
    }

    public void receptionner() {
        etat.receptionner(this);
    }

    public void archiver() {
        etat.archiver(this);
    }
}

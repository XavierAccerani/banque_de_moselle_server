package fr.florian.demo.modele;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String designation;

    @Column
    private double tauxTva;

    @Column
    private double prixUnitaire;

    @Column
    private boolean actif;

    @ManyToOne
    @JoinColumn
    private Article article;

    public Article() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(double tauxTva) {
        this.tauxTva = tauxTva;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public boolean isActif() {
        return actif;
    }
}

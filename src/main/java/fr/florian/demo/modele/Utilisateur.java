package fr.florian.demo.modele;
import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean actif;

    @Column
    private String nom;

    @Column
    private String prenom;

    /**
     * Ajout d'une jointure entre les deux tables
     * Un utilisateur appartient à une seule agence
     */
    @ManyToOne
    @JoinColumn
    private Agence agence;

    /**
     * A voir comment on gère les droits au niveau des attributs - avec LdapUtilisateurDetails
     * J'avais créé un ENUM pour les privilèges mais cela pose problème (collection d'enums).
     * Du coup, j'ai créé une classe GroupeUtilisateurs
     * Peut-être qu'une alternative pourrait être de faire appel à l'héritage ? (peut-être trop lourd)
     */
    @ManyToMany
    private List<GroupeUtilisateurs> groupeUtilisateurs;

    public Utilisateur() {}

    public Long getId() {
        return id;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<GroupeUtilisateurs> getGroupeUtilisateurs() {
        return groupeUtilisateurs;
    }

    public void setGroupeUtilisateurs(List<GroupeUtilisateurs> groupeUtilisateurs) {
        this.groupeUtilisateurs = groupeUtilisateurs;
    }
}

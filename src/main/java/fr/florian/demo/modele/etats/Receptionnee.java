package fr.florian.demo.modele.etats;

import fr.florian.demo.modele.Commande;

public class Receptionnee implements EtatsCommande {

    public Receptionnee() {}

    @Override
    public void rediger(Commande commande) {
        // On retourne un élément permettant d'afficher un message d'erreur avec un logger ?
    }

    @Override
    public void viser(Commande commande) {
        // On retourne un élément permettant d'afficher un message d'erreur avec un logger ?
    }

    @Override
    public void signer(Commande commande) {
        // On retourne un élément permettant d'afficher un message d'erreur avec un logger ?
    }

    @Override
    public void envoyer(Commande commande) {
        // On retourne un élément permettant d'afficher un message d'erreur avec un logger ?
    }

    @Override
    public void receptionner(Commande commande) {
        commande.setEtat(new Receptionnee());
    }
}

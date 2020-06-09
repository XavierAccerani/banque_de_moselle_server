package fr.florian.demo.modele.etats;

import fr.florian.demo.modele.Commande;

public class Envoyee implements EtatsCommande {

    private Envoyee() {}

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
        commande.setEtat(new Envoyee());
        commande.setDescriptifEtat("Envoyée");
    }

    @Override
    public void receptionner(Commande commande) {
        commande.setEtat(new Receptionnee());
        commande.setDescriptifEtat("Réceptionnée");
    }
}

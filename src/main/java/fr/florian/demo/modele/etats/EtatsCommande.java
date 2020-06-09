package fr.florian.demo.modele.etats;

import fr.florian.demo.modele.Commande;

public interface EtatsCommande {

    void rediger(Commande commande);

    void viser(Commande commande);

    void signer(Commande commande);

    void envoyer(Commande commande);

    void receptionner(Commande commande);
}

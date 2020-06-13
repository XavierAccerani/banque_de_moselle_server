package fr.florian.demo.modele.etat;

import com.fasterxml.jackson.annotation.JsonValue;
import fr.florian.demo.modele.Commande;

public interface EtatCommande {

    void creer(final Commande commande);
    void rediger(final Commande commande);
    void viser(final Commande commande);
    void signer(final Commande commande);
    void envoyer(final Commande commande);
    void receptionner(final Commande commande);
    void archiver(final Commande commande);

    // Toutes les classes implémentant cette interface vont retourner ceci
    @JsonValue
    default int versJson() {
        return Etats.getNumero(this.getClass());
    }
}

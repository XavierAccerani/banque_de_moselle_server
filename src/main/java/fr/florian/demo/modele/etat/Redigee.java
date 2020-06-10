package fr.florian.demo.modele.etat;

import fr.florian.demo.modele.Commande;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class Redigee implements EtatCommande {
    @Override
    public void creer(final Commande commande) {
        commande.setEtat(new Creee());
    }

    @Override
    public void rediger(final Commande commande) {
        // rien
    }

    @Override
    public void viser(final Commande commande) {
        commande.setEtat(new Visee());
    }

    @Override
    public void signer(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible de signer une commande au statut Rédigée");
    }

    @Override
    public void envoyer(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible d'envoyer une commande au statut Rédigée");
    }

    @Override
    public void receptionner(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible de réceptionner une commande au statut Rédigée");
    }

    @Override
    public void archiver(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible d'archiver une commande au statut Rédigée");
    }
}

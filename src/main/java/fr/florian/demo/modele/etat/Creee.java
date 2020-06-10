package fr.florian.demo.modele.etat;

import fr.florian.demo.modele.Commande;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class Creee implements EtatCommande {
    @Override
    public void creer(final Commande commande) {
        // rien
    }

    @Override
    public void rediger(final Commande commande) {
        commande.setEtat(new Redigee());
    }

    @Override
    public void viser(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible de viser une commande au statut Créée");
    }

    @Override
    public void signer(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible de signer une commande au statut Créée");
    }

    @Override
    public void envoyer(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible d'envoyer une commande au statut Créée");
    }

    @Override
    public void receptionner(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible de réceptionner une commande au statut Créée");
    }

    @Override
    public void archiver(final Commande commande) {
        throw new ResponseStatusException(BAD_REQUEST, "Impossible d'archiver une commande au statut Créée");
    }
}

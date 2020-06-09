package fr.florian.demo.service;

import fr.florian.demo.modele.Commande;
import fr.florian.demo.repo.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(final CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> findOne(final Long id) {
        return commandeRepository.findById(id);
    }

    public Commande ajouter(final Commande commande) {
        return commandeRepository.saveAndFlush(commande);
    }

    public Commande modifier(final Commande commande) {
        return commandeRepository.saveAndFlush(commande);
    }

    public void supprimer(final Commande commande) {
        commandeRepository.delete(commande);
    }

    // Ajout de méthodes permettant de sauvegarder automatiquement l'état d'une commande ?
    public Commande rediger(final Commande commande) {
        commande.getEtat().rediger(commande);
        return commandeRepository.saveAndFlush(commande);
    }

    public Commande viser(final Commande commande) {
        commande.getEtat().viser(commande);
        return commandeRepository.saveAndFlush(commande);
    }

    public Commande signer(final Commande commande) {
        commande.getEtat().signer(commande);
        return commandeRepository.saveAndFlush(commande);
    }

    public Commande envoyer(final Commande commande) {
        commande.getEtat().envoyer(commande);
        return commandeRepository.saveAndFlush(commande);
    }

    public Commande receptionner(final Commande commande) {
        commande.getEtat().receptionner(commande);
        return commandeRepository.saveAndFlush(commande);
    }
}

package fr.florian.demo.service;

import fr.florian.demo.modele.Utilisateur;
import fr.florian.demo.repo.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> findOne(final Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur ajouter(final Utilisateur utilisateur) {
        return utilisateurRepository.saveAndFlush(utilisateur);
    }

    public Utilisateur modifier(final Utilisateur utilisateur) {
        return utilisateurRepository.saveAndFlush(utilisateur);
    }

    public void supprimer(final Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }
}

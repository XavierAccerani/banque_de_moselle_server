package fr.florian.demo.service;

import fr.florian.demo.modele.Fournisseur;
import fr.florian.demo.repo.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurService(final FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Optional<Fournisseur> findOne(final Long id) {
        return fournisseurRepository.findById(id);
    }

    public Fournisseur ajouter(final Fournisseur fournisseur) {
        return fournisseurRepository.saveAndFlush(fournisseur);
    }

    public Fournisseur modifier(final Fournisseur fournisseur) {
        return fournisseurRepository.saveAndFlush(fournisseur);
    }

    public void supprimer(final Fournisseur fournisseur) {
        fournisseurRepository.delete(fournisseur);
    }
}

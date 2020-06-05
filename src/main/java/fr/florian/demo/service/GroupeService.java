package fr.florian.demo.service;

import fr.florian.demo.modele.Groupe;
import fr.florian.demo.repo.GroupeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {
    private final GroupeRepository groupeRepository;

    public GroupeService(final GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public List<Groupe> findAll() {
        return (List<Groupe>) groupeRepository.findAll();
    }
}

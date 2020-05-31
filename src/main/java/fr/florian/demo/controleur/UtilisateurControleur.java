package fr.florian.demo.controleur;

import fr.florian.demo.form.UtilisateurForm;
import fr.florian.demo.modele.Utilisateur;
import fr.florian.demo.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin
public class UtilisateurControleur {

    private final UtilisateurService utilisateurService;

    UtilisateurControleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Utilisateur> getOne(final @PathVariable Long id) {
        return utilisateurService.findOne(id)
                .map(utilisateurATrouver -> ResponseEntity.ok().body(utilisateurATrouver))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateur creer(final @Valid @RequestBody UtilisateurForm utilisateurForm) {
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurForm.getNom());
        utilisateur.setPrenom(utilisateurForm.getPrenom());
        return utilisateurService.ajouter(utilisateur);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Utilisateur> modifier(final @PathVariable Long id,
                                                final @Valid @RequestBody UtilisateurForm utilisateurForm) {
        return utilisateurService.findOne(id)
                .map(utilisateurAModifier -> {
                    utilisateurAModifier.setNom(utilisateurForm.getNom());
                    utilisateurAModifier.setPrenom(utilisateurForm.getPrenom());
                    return ResponseEntity.ok().body(utilisateurService.modifier(utilisateurAModifier));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> supprimer(final @PathVariable Long id) {
        return utilisateurService.findOne(id)
                .map(utilisateurASupprimer -> {
                    utilisateurService.supprimer(utilisateurASupprimer);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

package fr.florian.demo.controleur;

import fr.florian.demo.form.CommandeForm;
import fr.florian.demo.modele.Commande;
import fr.florian.demo.service.CommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/commandes")
@CrossOrigin
public class CommandeControleur {

    private final CommandeService commandeService;

    /**
     * Constructeur.
     */
    public CommandeControleur(final CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public List<Commande> getAll() {
        return commandeService.findAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Commande> getOne(final @PathVariable Long id) {
        return commandeService.findOne(id)
                              .map(commande -> ResponseEntity.ok().body(commande))
                              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commande creer(final @Valid @RequestBody CommandeForm commandeForm) {
        final Commande commande = new Commande();
        commande.setNumero(commandeForm.getNumero());
        commande.setFournisseur(commandeForm.getFournisseur());
        return commandeService.ajouter(commande);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Commande> modifier(final @PathVariable Long id,
                                             final @Valid @RequestBody CommandeForm commandeForm) {
        return commandeService.findOne(id)
                              .map(fournisseurAModifier -> {
                                  fournisseurAModifier.setNumero(commandeForm.getNumero());
                                  fournisseurAModifier.setFournisseur(commandeForm.getFournisseur());
                                  return ResponseEntity.ok().body(commandeService.modifier(fournisseurAModifier));
                              })
                              .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> supprimer(final @PathVariable Long id) {
        return commandeService.findOne(id)
                              .map(commande -> {
                                  commandeService.supprimer(commande);
                                  return ResponseEntity.ok().build();
                              })
                              .orElse(ResponseEntity.notFound().build());
    }
}

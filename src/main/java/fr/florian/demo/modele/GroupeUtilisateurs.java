package fr.florian.demo.modele;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupeUtilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String typeGroupe;
}

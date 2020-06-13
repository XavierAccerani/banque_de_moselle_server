package fr.florian.demo.modele.etat;

import java.util.function.Supplier;

import static java.util.Arrays.stream;

public enum Etats {
    CREEE(10, Creee.class, Creee::new),
    REDIGEE(20, Redigee.class, Redigee::new),
    VISEE(30, Visee.class, Visee::new),
    SIGNEE(40, Signee.class, Signee::new),
    ENVOYEE(50, Envoyee.class, Envoyee::new),
    RECEPTIONNEE(60, Receptionnee.class, Receptionnee::new),
    ARCHIVEE(70, Archivee.class, Archivee::new)
    ;

    private final Integer numero;
    // Class<?> permet de stocker le nom complet d'une classe
    // .class permet d'accéder au nom complet d'une classe
    private final Class<?> nomClasse;
    private final Supplier<EtatCommande> constructeur;


    Etats(final int numero, final Class<?> classe, final Supplier<EtatCommande> supplier) {
        this.numero = numero;
        this.nomClasse = classe;
        this.constructeur = supplier;
    }

    private Integer getNumero() {
        return numero;
    }

    public static int getNumero(final Class<?> classeATester) {
        // values() retourne toutes les valeurs d'une enum sous la forme d'un tableau
        return stream(values()).filter(v -> v.nomClasse.equals(classeATester))
                               .findFirst()
                               .orElseThrow(IllegalArgumentException::new)
                               .getNumero();
        // Fonction get() -> sur les Optional, permet de récupérer l'objet retourné.
    }

    public static EtatCommande getEtat(final Integer numeroATester) {
        Supplier<EtatCommande> supplier = stream(values()).filter(v -> v.numero.equals(numeroATester))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .constructeur;
        // .get() permet d'exécuter n'importe quelle fonction sans paramètre stockée dans une variable
        // Ici, on exécute la fonction stockée dans la variable "supplier"
        return supplier.get();
    }
}

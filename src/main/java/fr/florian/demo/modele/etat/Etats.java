package fr.florian.demo.modele.etat;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import static java.util.Arrays.stream;

public enum Etats {
    CREEE(10, Creee.class),
    REDIGEE(20, Redigee.class),
    VISEE(30, Visee.class),
    SIGNEE(40, Signee.class),
    ENVOYEE(50, Envoyee.class),
    RECEPTIONNEE(60, Receptionnee.class),
    ARCHIVEE(70, Archivee.class)
    ;

    private Integer numero;
    // Class<?> permet de stocker le nom complet d'une classe
    // .class permet d'accéder au nom complet d'une classe
    private Class<?> nomClasse;

    Etats(final int numero, final Class<?> classe) {
        this.numero = numero;
        this.nomClasse = classe;
    }

    public int getNumero() {
        return numero;
    }

    public Class<?> getNomClasse() {
        return nomClasse;
    }

    public static int getNumero(final Class<?> classeATester) {
        // values() retourne toutes les valeurs d'une enum sous la forme d'un tableau
        return stream(values()).filter(v -> v.nomClasse.equals(classeATester))
                .findFirst()
                .get()
                .getNumero();
        // Fonction get() -> sur les Optional, permet de récupérer l'objet retourné.
    }

    public static EtatCommande getEtat(final Integer numeroATester) {
        Class<?> nomClasse = stream(values()).filter(v -> v.numero.equals(numeroATester))
                .findFirst()
                .get()
                .getNomClasse();

        try {
            Constructor<EtatCommande> constructor = (Constructor<EtatCommande>) nomClasse.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

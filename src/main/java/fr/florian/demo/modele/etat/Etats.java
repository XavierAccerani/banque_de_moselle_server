package fr.florian.demo.modele.etat;

import java.lang.reflect.Constructor;

import static java.util.Arrays.stream;

public enum Etats {
    CREEE(10, Creee.class),
    REDIGEE(20, Redigee.class),
    VISEE(30, Visee.class),
    SIGNEE(40, Signee.class),
    ENVOYEE(50, Envoyee.class),
    RECEPTIONNEE(60, Receptionnee.class),
    ARCHIVEE(70, Archivee.class);

    private final Integer numero;
    private final Class<?> nomClasse;

    Etats(final int numero, final Class<?> nomClasse) {
        this.numero = numero;
        this.nomClasse = nomClasse;
    }

    public Integer getNumero() {
        return numero;
    }

    public Class<?> getNomClasse() {
        return nomClasse;
    }

    public static int getNumero(final Class<?> classeATester) {
        return stream(values()).filter(v -> v.nomClasse.equals(classeATester))
                               .findFirst()
                               .orElseThrow(IllegalArgumentException::new)
                               .getNumero();
    }

    public static EtatCommande getEtat(final Integer numeroATester) {
        Class<?> nomClasse = stream(values()).filter(v -> v.numero.equals(numeroATester))
                                             .findFirst()
                                             .orElseThrow(IllegalArgumentException::new)
                                             .getNomClasse();

        try {
            Constructor<EtatCommande> constructor = (Constructor<EtatCommande>) nomClasse.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}

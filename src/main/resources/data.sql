INSERT INTO fournisseur (nom, siret, actif) VALUES ('apple', '111', 1);
INSERT INTO fournisseur (nom, siret, actif) VALUES ('google', '2222', 1);

commit;

INSERT INTO commande (numero, fournisseur_id) VALUES ('1234', 1);
INSERT INTO commande (numero, fournisseur_id) VALUES ('5678', 2);

commit;

INSERT INTO ligne_commande (reference, prix, quantite, tva) VALUES ('bureau', 50, 1, 1.20);
INSERT INTO ligne_commande (reference, prix, quantite, tva) VALUES ('souris', 7, 4, 1.20);

commit;

INSERT INTO COMMANDE_LIGNES_COMMANDES  (commande_id, lignes_commandes_id) VALUES (1, 1);
INSERT INTO COMMANDE_LIGNES_COMMANDES  (commande_id, lignes_commandes_id) VALUES (1, 2);

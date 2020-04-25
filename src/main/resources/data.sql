INSERT INTO fournisseur (nom, siret) VALUES ('apple', '111');
INSERT INTO fournisseur (nom, siret) VALUES ('google', '2222');

commit;

INSERT INTO commande (numero, fournisseur_id) VALUES ('1234', 1);
INSERT INTO commande (numero, fournisseur_id) VALUES ('5678', 2);

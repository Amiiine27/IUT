/* -----------------------------------------------------------------------
BASE de DONNEES : IUT
Version : 2.0
Auteur : Mario CATALDI - Myriam Lamolle
Date création : 24/06/2022
------------------------------------------------------------------------- */
/* Essai de BD SQL.*/
DROP SCHEMA IF EXISTS  iut;
CREATE SCHEMA iut;

DROP TABLE IF EXISTS iut.notes CASCADE ; -- CASCADE car objet VIEW, etc. possible pour ma BD
DROP TABLE IF EXISTS iut.ressource CASCADE;
DROP TABLE IF EXISTS iut.enseignant CASCADE ;
DROP TABLE IF EXISTS iut.etudiant CASCADE ;




CREATE TABLE iut.enseignant (
	idEns INT,
	nom VARCHAR(32) ,
	prenom VARCHAR(32) ,
	dept VARCHAR(32),
    CONSTRAINT pk_enseignant PRIMARY KEY (idEns)
);

CREATE TABLE iut.etudiant (
	idetud INT,
	nom VARCHAR(32),
	prenom VARCHAR(32),
	groupe VARCHAR(12),
    CONSTRAINT pk_etudiant PRIMARY KEY (idetud)
);

CREATE TABLE iut.ressource (
	idres VARCHAR(8),
	nom VARCHAR(128),
 	semestre INT,
	coef FLOAT,
	responsable INT,
    CONSTRAINT pk_ressource PRIMARY KEY (idRes),
	CONSTRAINT fk_ressource_enseignant FOREIGN KEY (responsable) REFERENCES iut.enseignant (idEns)
    );

CREATE TABLE iut.notes (
	idetud INT,
	idres VARCHAR(8), 
	datenote DATE,
	note FLOAT(2),
	CONSTRAINT pk_notes PRIMARY KEY (idEtud, idRes),
	CONSTRAINT fk_notes_etudiant FOREIGN KEY (idEtud) REFERENCES iut.etudiant (idetud),
	CONSTRAINT fk_notes_ressource FOREIGN KEY (idRes) REFERENCES iut.ressource (idres)
);


-- table enseignant
INSERT INTO iut.enseignant (idEns, nom, prenom, dept) VALUES 
	(0, 'Rety', 'Jean-Hugues','INFO'),
	(1, 'Lamolle','Myriam','INFO'),
	(2, 'Homps','Marc','INFO'),
	(3, 'Simonot','Marianne','INFO'),
	(4, 'Ricordeau', 'Anne','INFO'),
	(5, 'Georges','Rémi','INFO'),
	(6, 'Delmas','Guylain','INFO'),
	(7, 'Nauwynck','Nédra','INFO'),
	(8, 'Bonnot','Philippe','INFO'),
	(9, 'Clément-Comparot','Véronique','INFO'),
	(10, 'Bossard','Aurélien','INFO'),
	(11, 'Cataldi','Mario','INFO'),
	(12, 'Golven', 'Amélie','INFO'),
	(13, 'Ballay-Dally', 'Charlotte', 'QLIO'), 
	(14, 'Groff', 'Geoffrey','INFO'),
	(15, 'Bellabes', 'Sihem','INFO'),
	(21, 'Chebbi', 'Imen', NULL), 
	(22, 'Tobbelem', 'Jocelin', NULL), 
	(23, 'Mockel', 'Mehdi', NULL), 
	(24, 'Mourel', 'Frédéric', NULL), 
	(25, 'Nyzam', 'Valentin', NULL),
	(30, 'Kamal','Rachida', NULL) ;

-- table etudiant
INSERT INTO iut.etudiant (idetud, nom, prenom, groupe) VALUES 
(0, 'Turing','Michel', 'A1'), (1, 'Roning', 'Ada', 'A2'), (2, 'Barty', 'Charles', 'B1'),
(3, 'Berry', 'Gérard', 'B2'), (4, 'Lee', 'Tim', 'C1');
INSERT INTO iut.etudiant (idetud, nom, prenom, groupe) VALUES 
(5, 'Meyer', 'Bertrand', 'C2'), (6, 'Wirth', 'Niklaus', 'A1'), (7, 'Talon', 'Achille', 'A1'), (8, 'Rubens', 'Marc', 'A2'), (9, 'Menner', 'Philippe', 'A1');;;

-- table module[refmod, intitule, classe, coef, volHoraireCM, volHoraireTD, volHoraireTP, idens]
-- idEns représente le responsable du module
INSERT INTO iut.ressource VALUES 
	('R1.01', 'Initiation au développement', 1, '3.5', 0),
	('R1.02', 'Développement d interfaces web', 1, '2.5', 15),
	('R1.03', 'Introduction à l Architecture des Ordinateurs', 1, '2.5', 7),
	('R1.04', 'Introduction aux Systèmes d exploitation', 1, '3.5', 6),
	('R1.05', 'Introduction aux bases de données SQL', 1, '3.5', 11),
	('R1.06', 'Mathématiques discrètes', 1, '2.5', 2),
	('R1.07', 'Outils Mathématiques Fondamentaux', 1, '2.0', 4),	
	('R1.10', 'Anglais Technique', 1, '1.5', 13),
	('R1.12', 'Projet professionnel et personnel', 1, '1.5', 9);	

INSERT INTO iut.ressource VALUES 
	('R2.01', 'Développement orienté objets', 2, '3.5', 2),
	('R2.02', 'Développement d applications avec IHM', 2, '2.5', 3),
	('R2.03', 'Qualité de développement', 2, '2.5', 3),
	('R2.04', 'Communication et fonctionnement bas niveau', 2, '1.5', 8),
	('R2.05', 'Introduction aux services réseaux', 2, '1.5', 6),
	('R2.06', 'Exploitation d une base de données', 2, '2.5', 11);



-- table notes 
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (0, 'R1.01', 12);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (0, 'R1.02', 13);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (1, 'R1.01', 14);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (1, 'R1.04', 9);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (2, 'R1.01', 12);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (2, 'R1.03', 16);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (2, 'R1.06', 10);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (3, 'R1.01', 12);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (4, 'R1.02', 8);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (4, 'R1.01', 12);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (5, 'R2.01', 8);
INSERT INTO iut.notes(idEtud,idRes,note) VALUES (6, 'R2.06', 10);







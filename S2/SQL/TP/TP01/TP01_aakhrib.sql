-- ..........
-- Auteur : Amine Akhrib
-- TP : TP01
-- ....................

---- EXERCICE N°1 :


-- (f)

		DROP SCHEMA IF EXISTS etudes CASCADE;
		CREATE SCHEMA etudes;

		DROP TABLE IF EXISTS etudes.Univ CASCADE;

		CREATE TABLE etudes.Univ(
			idEtud SERIAL,
			nomEtud VARCHAR(50),
			fraisScol VARCHAR(4),
			discipline VARCHAR(16),
			cours1 VARCHAR(16),
			cours2 VARCHAR(16),
			cours3 VARCHAR(16),
			
			CONSTRAINT pk_idEtud PRIMARY KEY(idEtud)
		);

		INSERT INTO etudes.Univ (nomEtud, fraisScol, discipline, cours1, cours2, cours3) VALUES 
			('Alice Dubois', 200, 'Economie', 'Economie1', 'Biologie1', NULL),
			('Bob Dupont', 500, 'Informatique', 'Biologie1', 'Intro Business', 'Programmation2'),
			('Chris Durand', 400, 'Médecine', 'Biologie2', 'Biologie1', NULL),
			('Diana Duclos', 850, 'Dentaire', NULL, NULL, NULL);


		-- aakhrib=> INSERT INTO Univ (nometud)
		-- VALUES ('Eliot Martin')
		-- ;

-- (g)

		-- aakhrib=> UPDATE univ
		--SET cours2 = 'Intro Biologie'
		--WHERE idEtud=1;
		--UPDATE 1
		--aakhrib=> UPDATE univ
		--SET cours2 = 'Intro Biologie'
		--WHERE idEtud=3;
		--UPDATE 1

		--aakhrib=> SELECT *
		--FROM univ ORDER BY idEtud;

		-- idetud |   nometud    | fraisscol |  discipline  |     cours1     |     cours2     |     cours3     
		----------+--------------+-----------+--------------+----------------+----------------+----------------
		--      1 | Alice Dubois | 200       | Economie     | Economie1      | Intro Biologie | 
		--      2 | Bob Dupont   | 500       | Informatique | Intro Biologie | Intro Business | Programmation2
		--      3 | Chris Durand | 400       | Médecine     | Biologie2      | Intro Biologie | 
		--      4 | Diana Duclos | 850       | Dentaire     |                |                | 
		--      5 | Eliot Martin |           |              |                |                | 

-- (h)

		--aakhrib=> SELECT *
		--FROM univ ORDER BY idEtud;
		-- idetud |   nometud    | fraisscol |  discipline  |     cours1     |     cours2     |     cours3     
		----------+--------------+-----------+--------------+----------------+----------------+----------------
		--      1 | Alice Dubois | 200       | Economie     | Economie1      | Intro Biologie | 
		--      2 | Bob Dupont   | 500       | Informatique | Intro Biologie | Intro Business | Programmation2
		--      4 | Diana Duclos | 850       | Dentaire     |                |                | 
		--      5 | Eliot Martin |           |              |                |                | 

-- (i)


---- EXERCICE N°2 :

		CREATE TABLE etudes.etudiants(
			nomEtud VARCHAR(50),
			fraisScol VARCHAR(4),
			dateNaiss VARCHAR(12),
			cours1 VARCHAR(16),
			cours2 VARCHAR(16),
			cours3 VARCHAR(16),
			cours4 VARCHAR(16),
			nomProf VARCHAR(50),
			discipline VARCHAR(16)
		);

-- (c)

		--aakhrib=> ALTER TABLE etudiants
		--aakhrib-> ADD idEtud SERIAL;
		--ALTER TABLE
		--aakhrib=> SELECT *
		--FROM etudiants;
		-- nometud | fraisscol | datenaiss | cours1 | cours2 | cours3 | cours4 | nomprof | discipline | idetud 
		-----------+-----------+-----------+--------+--------+--------+--------+---------+------------+--------

-- (d)

		--aakhrib=> \d
		--                   Liste des relations
		-- Schéma |         Nom          |   Type   | Propriétaire 
		----------+----------------------+----------+--------------
		-- etudes | etudiants            | table    | aakhrib
 		-- etudes | etudiants_idetud_seq | séquence | aakhrib
		-- etudes | univ                 | table    | aakhrib
		-- etudes | univ_idetud_seq      | séquence | aakhrib

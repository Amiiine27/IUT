DROP SCHEMA IF EXISTS agenceVehicule CASCADE;

CREATE SCHEMA agenceVehicule;
CREATE TABLE agenceVehicule.modeleVoiture
(
	code VARCHAR,
	marque VARCHAR,
	typeEssence VARCHAR(50),
	
	CONSTRAINT pk_modeleVoiture PRIMARY KEY(code)
);

CREATE TABLE agenceVehicule.client
(
	nom VARCHAR,
	prenom VARCHAR,
	numeroPermisConduire VARCHAR, 
	adresse VARCHAR(50),
	
	CONSTRAINT pk_numeroPermisConduire PRIMARY KEY(numeroPermisConduire)
); 

CREATE TABLE agenceVehicule.voiture
(
	immatriculation VARCHAR,
	couleur VARCHAR,
	anneImmatriculation INT,
	construitPar VARCHAR,

	CONSTRAINT pk_voiture PRIMARY KEY(immatriculation),
	
	CONSTRAINT fk_voiture_modeleVoiture FOREIGN 
	KEY(construitPar) REFERENCES 
	agenceVehicule.modeleVoiture(code)
	
);

CREATE TABLE agenceVehicule.locationVoiture
(
	numConducteur VARCHAR,
	plaque VARCHAR,
	dateDebut DATE,
	dateFin DATE,
	
	CONSTRAINT pk_locationVoiture PRIMARY KEY(plaque, dateDebut),

	CONSTRAINT fk_locationVoiture_client FOREIGN 
	KEY(numConducteur) REFERENCES 
	agenceVehicule.client(numeroPermisConduire),

	CONSTRAINT fk_locationVoiture_voiture FOREIGN 
	KEY(plaque) REFERENCES 
	agenceVehicule.voiture(immatriculation)
);

CREATE TABLE agenceVehicule.achatVoiture
(
	numConducteur VARCHAR,
	plaque VARCHAR,
	dateAchat DATE,
	prixAchat INT,
	
	CONSTRAINT pk_achatVoiture PRIMARY KEY(plaque, numConducteur),	
	
	CONSTRAINT fk_achatVoiture_client FOREIGN 
	KEY(numConducteur) REFERENCES 
	agenceVehicule.client(numeroPermisConduire),

	CONSTRAINT fk_achatVoiture_voiture FOREIGN KEY(plaque) 
	REFERENCES agenceVehicule.voiture(immatriculation)

);

INSERT INTO agenceVehicule.modeleVoiture (code, marque, typeEssence)
 VALUES
 ('12345', 'Peugeot', 'SP95'),
 ('54321', 'Renault', 'Essence'),
 ('02468', 'Ferrari', 'Diesel'),
 ('86420', 'Suzuki', 'Ethanol');


INSERT INTO agenceVehicule.client (prenom, nom, numeroPermisConduire, adresse)
 VALUES
 ('Rébecca', 'Armand', '0123456789', '4 chemin Frédéric Lecomte'),
 ('Aimée', 'Hebert', '9876543210', '728, impasse Louise Perrin'),
 ('Marielle', 'Ribeiro', '0246813579', '24, avenue Bernard Mendes'),
 ('Hilaire', 'Savary', '1357902468', '103, place Camus');



INSERT INTO agenceVehicule.voiture (immatriculation, couleur, anneImmatriculation, construitPar)
 VALUES
 ('AZERTYUIOP', 'Rouge', '2022', '02468'),
 ('AETUOZRYIP', 'Bleu', '2012', '12345'),
 ('POIUYTREZA', 'Saumon', '2021', '86420'),
 ('PIYRZOUTEA', 'Noir', '2015', '54321');



INSERT INTO agenceVehicule.locationVoiture (numConducteur, plaque, dateDebut, dateFin)
 VALUES
 ('0123456789', 'POIUYTREZA', '2022-05-12', '2022-05-20'),
 ('0246813579', 'AZERTYUIOP', '2022-09-25', '2022-09-30');




INSERT INTO agenceVehicule.achatVoiture (numConducteur, plaque, dateAchat, prixAchat)
 VALUES
 ('9876543210', 'AETUOZRYIP', '2022-08-18', 93270),
 ('1357902468', 'PIYRZOUTEA', '2022-10-01', 75000);



-- Table Filiere
CREATE TABLE filiere (
    id_filiere INT auto_increment PRIMARY KEY,
    nom VARCHAR(255),
    duree INT ,
    description TEXT
)ENGINE=InnoDB;

-- Table Niveau
CREATE TABLE niveau (
    id_niveau INT auto_increment PRIMARY KEY,
    id_filiere INT,
    libelle VARCHAR(6) 
)ENGINE=InnoDB;

-- Table Module
CREATE TABLE module (
    id_module INT auto_increment PRIMARY KEY,
    id_filiere INT,
    nom VARCHAR(255)
)ENGINE=InnoDB;

-- Table Matiere
CREATE TABLE matiere (
    id_matiere INT auto_increment PRIMARY KEY,
    id_module INT,
	volume_horaire INT,
    nom VARCHAR(255)
)ENGINE=InnoDB;

-- Table Etudiant
CREATE TABLE etudiant (
    id_etudiant INT auto_increment PRIMARY KEY,
    matricule VARCHAR(20) UNIQUE,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    adresse VARCHAR(255),
    telephone VARCHAR(15),
    email VARCHAR(255),
    sexe VARCHAR(40),
    date_naissance DATE
	)ENGINE=InnoDB;

-- Table Diplome
CREATE TABLE diplome (
    id_diplome INT  auto_increment PRIMARY KEY,
    id_etudiant INT,
    nom VARCHAR(255),
    date_obtention DATE,
    niveau VARCHAR(20)
)ENGINE=InnoDB;

-- Table Inscription
CREATE TABLE inscription (
    id_inscription INT auto_increment PRIMARY KEY,
    id_etudiant INT,
    id_niveau INT,
    date_inscription DATE
)ENGINE=InnoDB;


ALTER TABLE niveau 
ADD CONSTRAINT FK_NIVEAU_ID_NIVEAU FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);

ALTER TABLE module 
ADD CONSTRAINT FK_MODULE_ID_FILIERE FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere);

ALTER TABLE matiere 
ADD CONSTRAINT FK_MATIERE_ID_MODULE FOREIGN KEY (id_module) REFERENCES module(id_module);


ALTER TABLE diplome 
ADD CONSTRAINT FK_DIPLOME_ID_ETUDIANT FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant);

ALTER TABLE inscription 
ADD CONSTRAINT FK_INSCRIPTION_ID_ETUDIANT FOREIGN KEY (id_etudiant) REFERENCES etudiant(id_etudiant);

ALTER TABLE inscription 

ADD CONSTRAINT FK_INSCRIPTION_ID_NIVEAU FOREIGN KEY (id_niveau) REFERENCES niveau(id_niveau);
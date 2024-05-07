CREATE DATABASE gestion_de_stock;
USE gestion_de_stock;

CREATE TABLE Produits(
   ID_Produits VARCHAR(50),
   Nom_produit VARCHAR(100),
   Stock INT,
   Prix DECIMAL(15,2),
   PRIMARY KEY(ID_Produits)
);

CREATE TABLE Rapports(
   ID_Rapports VARCHAR(50),
   Vendu VARCHAR(100),
   numStock INT,
   ID_Produits VARCHAR(50) NOT NULL,
   PRIMARY KEY(ID_Rapports),
   FOREIGN KEY(ID_Produits) REFERENCES Produits(ID_Produits)
);

CREATE TABLE Ventes(
   ID_Ventes VARCHAR(50),
   Produit_ventes VARCHAR(100),
   transactions DECIMAL(15,2),
   ID_Rapports VARCHAR(50) NOT NULL,
   PRIMARY KEY(ID_Ventes),
   FOREIGN KEY(ID_Rapports) REFERENCES Rapports(ID_Rapports)
);

CREATE TABLE Fournisseurs(
   ID_Fournisseurs VARCHAR(50),
   Nom VARCHAR(50),
   Prenom VARCHAR(50),
   Produit_fournisseurs VARCHAR(100),
   ID_Ventes VARCHAR(50) NOT NULL,
   PRIMARY KEY(ID_Fournisseurs),
   FOREIGN KEY(ID_Ventes) REFERENCES Ventes(ID_Ventes)
);

CREATE TABLE Tenue(
   ID_Produits VARCHAR(50),
   ID_Fournisseurs VARCHAR(50),
   PRIMARY KEY(ID_Produits, ID_Fournisseurs),
   FOREIGN KEY(ID_Produits) REFERENCES Produits(ID_Produits),
   FOREIGN KEY(ID_Fournisseurs) REFERENCES Fournisseurs(ID_Fournisseurs)
);

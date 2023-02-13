-- Adminer 4.8.1 MySQL 5.5.5-10.10.2-MariaDB-1:10.10.2+maria~ubu2204 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

USE `arosaje`;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `annonce`;
CREATE TABLE `annonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_postal` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  `id_gardien` int(11) DEFAULT NULL,
  `proprietaire_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq52grpmyo6tbtq0xau7vhqmyh` (`id_gardien`),
  KEY `FKky737w35gdp26al6ehihynvh0` (`proprietaire_id`),
  CONSTRAINT `FKky737w35gdp26al6ehihynvh0` FOREIGN KEY (`proprietaire_id`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FKq52grpmyo6tbtq0xau7vhqmyh` FOREIGN KEY (`id_gardien`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `annonce` (`id`, `code_postal`, `numero`, `rue`, `ville`, `description`, `etat`, `image`, `titre`, `id_gardien`, `proprietaire_id`) VALUES
(1,	44400,	10,	'Rue du test',	'Nantes',	'Description de l\'annonce 1',	'ouvert',	NULL,	'My first annonce 1',	NULL,	NULL),
(2,	44470,	15,	'Rue du testo',	'Carquefou',	'Description 2',	'ouvert',	NULL,	'Annonce 2',	NULL,	NULL),
(3,	35000,	75,	'Rue du test',	'Rennes',	'Description hey',	'ouvert',	NULL,	'Annonce 3',	NULL,	NULL),
(4,	49000,	45,	'Rue du testttt',	'Angers',	'Nice description',	'ouvert',	NULL,	'Annonce angers',	NULL,	NULL),
(5,	44400,	78,	'Rue des tests',	'Nantes',	'Description de Nantes',	'ouvert',	NULL,	'Annonce nantes',	NULL,	NULL);

DROP TABLE IF EXISTS `annonce_plantes`;
CREATE TABLE `annonce_plantes` (
  `id_annonce` int(11) NOT NULL,
  `id_plante` int(11) NOT NULL,
  PRIMARY KEY (`id_annonce`,`id_plante`),
  KEY `FKi42h7cvo4kcggv1nfoep9q0uj` (`id_plante`),
  CONSTRAINT `FKi42h7cvo4kcggv1nfoep9q0uj` FOREIGN KEY (`id_plante`) REFERENCES `plante` (`id`),
  CONSTRAINT `FKou2q1g5aistu8pqigv3gkcmgs` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `annonce_plantes` (`id_annonce`, `id_plante`) VALUES
(1,	3),
(2,	7),
(3,	1),
(4,	8),
(5,	9);

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `messgae` varchar(255) DEFAULT NULL,
  `photo` varbinary(255) DEFAULT NULL,
  `annonce_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtqlfbx6v95l33pu7k0bbgqbmp` (`annonce_id`),
  CONSTRAINT `FKtqlfbx6v95l33pu7k0bbgqbmp` FOREIGN KEY (`annonce_id`) REFERENCES `annonce` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `plante`;
CREATE TABLE `plante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `arrosage` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dimension` varchar(255) DEFAULT NULL,
  `exposition` varchar(255) DEFAULT NULL,
  `famille` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `plante` (`id`, `arrosage`, `description`, `dimension`, `exposition`, `famille`, `nom`, `photo`) VALUES
(1,	'Journalier',	'Ma magnifique plante numéro 1',	'Grande',	'Beaucoup',	'Plante',	'Plante 1',	NULL),
(2,	'Chaque mois',	'Mon magnifique cactous',	'Petit',	'Beaucup',	'Cactus',	'Cactus 1',	NULL),
(3,	'Hebdomadaire',	'Quelle belles roses wa',	'Moyen',	'Moyen',	'Rose',	'Rose 1',	NULL),
(4,	'Hebdomadaire',	'Description',	'Petit-moyen',	'Peu',	'Arbre',	'Arbre 1',	NULL),
(5,	'Journalier',	'Ma magnifique plante',	'moyen',	'beaucoup',	'plante',	'Plante 2',	NULL),
(6,	'Journalier',	'Ma magnifique plante numéro 1',	'Moyen',	'Beaucup',	'Plante',	'Plante 3',	NULL),
(7,	'Hebdomadaire',	'Quelle belles roses wa',	'Moyen',	'Peu',	'Rose',	'Rose 2',	NULL),
(8,	'Hebdomadaire',	'Ma magnifique plante',	'moyen',	'Moyen',	'Arbre',	'Arbre 2',	NULL),
(9,	'Chaque mois',	'Ma magnifique plante',	'Petit-moyen',	'Beaucup',	'Arbre',	'Arbre 3',	NULL),
(10,	'Chaque mois',	'Mon magnifique cactous',	'Petit',	'Beaucup',	'Cactus',	'Cactus 2',	NULL);

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `dtype` varchar(31) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `entreprise` varchar(255) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `specialite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- 2023-02-03 07:35:49

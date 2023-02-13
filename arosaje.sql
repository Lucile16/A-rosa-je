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
(1, 75001, 12, "Rue de la Paix", "Paris", "Je cherche un gardien pour mes plantes d'intérieur", "Disponible", NULL, "Gardien pour mes plantes", NULL, NULL),
(2, 75016, 15, "Avenue des Ternes", "Paris", "Je suis à la recherche d'un gardien pour mes plantes d'extérieur", "Disponible", NULL, "Gardien pour mes jardins", NULL, NULL),
(3, 75010, 20, "Rue de Belleville", "Paris", "Je cherche un gardien pour mes cactus", "Disponible", NULL, "Gardien pour mes cactus", NULL, NULL),
(4, 75017, 25, "Rue de Clichy", "Paris", "Je suis à la recherche d'un gardien pour mes bonsaïs", "Disponible", NULL, "Gardien pour mes bonsaïs", NULL, NULL),
(5, 75011, 30, "Rue de la Roquette", "Paris", "Je cherche un gardien pour mes orchidées", "Disponible", NULL, "Gardien pour mes orchidées", NULL, NULL);

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
(1, "Une fois par semaine", "Plante grasse facile à entretenir", "Hauteur: 60 cm", "Lumière indirecte", "Cactacées", "Cactus 1", NULL),
(2, "Deux fois par semaine", "Plante d'intérieur facile à entretenir", "Hauteur: 50 cm", "Lumière indirecte", "Bonsaïs", "Bonsaï 1", NULL),
(3, "Une fois par jour", "Plante d'intérieur exotique", "Hauteur: 70 cm", "Lumière directe", "Orchidées", "Orchidée 1", NULL),
(4, "Deux fois par jour", "Plante grasse d'intérieur", "Hauteur: 40 cm", "Lumière indirecte", "Cactacées", "Cactus 2", NULL),
(5, "Une fois par semaine", "Plante d'intérieur facile à entretenir", "Hauteur: 30 cm", "Lumière indirecte", "Bonsaïs", "Bonsaï 2", NULL),
(6, "Deux fois par jour", "Plante exotique", "Hauteur: 90 cm", "Lumière directe", "Orchidées", "Orchidée 2", NULL),
(7, "Une fois par jour", "Plante grasse facile à entretenir", "Hauteur: 60 cm", "Lumière indirecte", "Cactacées", "Cactus 3", NULL),
(8, "Deux fois par semaine", "Plante d'intérieur facile à entretenir", "Hauteur: 50 cm", "Lumière indirecte", "Bonsaïs", "Bonsaï 3", NULL),
(9, "Une fois par jour", "Plante exotique", "Hauteur: 70 cm", "Lumière directe", "Orchidées", "Orchidée 3", NULL),
(10, "Deux fois par semaine", "Plante grasse d'intérieur", "Hauteur: 40 cm", "Lumière indirecte", "Cactacées", "Cactus 4", NULL),
(11, "Une fois par jour", "Plante d'intérieur facile à entretenir", "Hauteur: 30 cm", "Lumière indirecte", "Bonsaïs", "Bonsaï 4", NULL),
(12, "Deux fois par semaine", "Plante exotique", "Hauteur: 90 cm", "Lumière directe", "Orchidées", "Orchidée 4", NULL),
(13, "Une fois par semaine", "Plante grasse facile à entretenir", "Hauteur: 60 cm", "Lumière indirecte", "Cactacées", "Cactus 5", NULL),
(14, "Deux fois par jour", "Plante d'intérieur facile à entretenir", "Hauteur: 50 cm", "Lumière indirecte", "Bonsaïs", "Bonsaï 5", NULL);

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

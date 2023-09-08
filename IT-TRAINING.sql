-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : ven. 01 sep. 2023 à 07:49
-- Version du serveur : 8.0.33
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `IT-TRAINING`
--

-- --------------------------------------------------------

--
-- Structure de la table `Category`
--

CREATE TABLE `Category` (
  `Id_Category` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Course`
--

CREATE TABLE `Course` (
  `Id_Course` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `createdAt` date DEFAULT NULL,
  `updatedAt` date DEFAULT NULL,
  `Id_Subtopic` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Evaluation`
--

CREATE TABLE `Evaluation` (
  `Id_Evaluation` tinyint NOT NULL,
  `createdAt` date DEFAULT NULL,
  `UpdatedAt` date DEFAULT NULL,
  `grade` tinyint DEFAULT NULL,
  `hasRequirements` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Role`
--

CREATE TABLE `Role` (
  `Id_Role` tinyint NOT NULL,
  `rights` smallint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Session`
--

CREATE TABLE `Session` (
  `Id_Evaluation` int NOT NULL,
  `Id_Course` int NOT NULL,
  `Id_Session` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `location` varchar(50) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `slot` tinyint DEFAULT NULL,
  `createdAt` date DEFAULT NULL,
  `UpdatedAt` date DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Subtopic`
--

CREATE TABLE `Subtopic` (
  `Id_Subtopic` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Topic`
--

CREATE TABLE `Topic` (
  `Id_Category` int NOT NULL,
  `Id_Topic` tinyint NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Users`
--

CREATE TABLE `Users` (
  `Id_Role` int NOT NULL,
  `Id_Users` tinyint NOT NULL,
  `firstname` varchar(33) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `lastname` varchar(33) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb3_general_mysql500_ci NOT NULL,
  `birthdate` varchar(10) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL,
  `status` varchar(25) COLLATE utf8mb3_general_mysql500_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_mysql500_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Category`
--
ALTER TABLE `Category`
  ADD PRIMARY KEY (`Id_Category`);

--
-- Index pour la table `Course`
--
ALTER TABLE `Course`
  ADD PRIMARY KEY (`Id_Course`);

--
-- Index pour la table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD PRIMARY KEY (`Id_Evaluation`);

--
-- Index pour la table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`Id_Role`);

--
-- Index pour la table `Session`
--
ALTER TABLE `Session`
  ADD PRIMARY KEY (`Id_Evaluation`,`Id_Course`,`Id_Session`);

--
-- Index pour la table `Subtopic`
--
ALTER TABLE `Subtopic`
  ADD PRIMARY KEY (`Id_Subtopic`);

--
-- Index pour la table `Topic`
--
ALTER TABLE `Topic`
  ADD PRIMARY KEY (`Id_Category`,`Id_Topic`);

--
-- Index pour la table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`Id_Role`,`Id_Users`),
  ADD UNIQUE KEY `email` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2019 at 08:28 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `chefs`
--

CREATE TABLE `chefs` (
  `chef_id` int(11) NOT NULL,
  `employe_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `service_nom` varchar(50) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `archived` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chefs`
--

INSERT INTO `chefs` (`chef_id`, `employe_id`, `user_id`, `service_nom`, `date_creation`, `date_modification`, `archived`) VALUES
(1, 1, 3, 'service1', '2019-05-10 00:00:00', '2019-05-10 00:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `documents`
--

CREATE TABLE `documents` (
  `document_id` int(11) NOT NULL,
  `document_nom` varchar(100) NOT NULL,
  `document_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `documents`
--

INSERT INTO `documents` (`document_id`, `document_nom`, `document_type`) VALUES
(1, 'document1', 'document_type_1');

-- --------------------------------------------------------

--
-- Table structure for table `employes`
--

CREATE TABLE `employes` (
  `employe_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `somme` varchar(10) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `genre` varchar(10) NOT NULL,
  `CIN` varchar(10) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `date_naissance` date NOT NULL,
  `date_recrutement` date NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `archived` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employes`
--

INSERT INTO `employes` (`employe_id`, `user_id`, `somme`, `nom`, `prenom`, `email`, `genre`, `CIN`, `telephone`, `date_naissance`, `date_recrutement`, `date_creation`, `date_modification`, `archived`) VALUES
(1, 2, 'C100', 'Temmar', 'Naoufal', 'naoufal@email.com', 'male', 'C111111', '0610203040', '1997-01-01', '2010-01-01', '2019-05-10 00:00:00', '2019-05-10 00:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `etapes`
--

CREATE TABLE `etapes` (
  `etape_id` int(11) NOT NULL,
  `employe_id` int(11) NOT NULL,
  `etape_nom` varchar(100) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `archived` tinyint(1) NOT NULL,
  `nbr_documents` int(11) NOT NULL,
  `documents` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etapes`
--

INSERT INTO `etapes` (`etape_id`, `employe_id`, `etape_nom`, `date_creation`, `date_modification`, `archived`, `nbr_documents`, `documents`) VALUES
(1, 1, 'etape1', '2019-05-10 00:00:00', '2019-05-10 00:00:00', 0, 1, '1');

-- --------------------------------------------------------

--
-- Table structure for table `procedures`
--

CREATE TABLE `procedures` (
  `procedure_id` int(11) NOT NULL,
  `chef_id` int(11) NOT NULL,
  `procedure_nom` varchar(100) NOT NULL,
  `service_nom` varchar(50) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `archived` tinyint(1) NOT NULL,
  `nbr_documents` int(11) NOT NULL,
  `documents` varchar(100) NOT NULL,
  `nbr_etapes` int(11) NOT NULL,
  `etapes` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `procedures`
--

INSERT INTO `procedures` (`procedure_id`, `chef_id`, `procedure_nom`, `service_nom`, `date_creation`, `date_modification`, `archived`, `nbr_documents`, `documents`, `nbr_etapes`, `etapes`) VALUES
(1, 1, 'procedure1', 'service1', '2019-05-10 00:00:00', '2019-05-10 00:00:00', 0, 1, '1', 1, '1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `date_creation` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `role`, `date_creation`) VALUES
(1, 'admin', 'admin', 'admin', '2019-05-10 00:00:00'),
(2, 'employe1', 'employe1', 'employe', '2019-05-10 00:00:00'),
(3, 'chef1', 'chef1', 'chef', '2019-05-10 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chefs`
--
ALTER TABLE `chefs`
  ADD PRIMARY KEY (`chef_id`),
  ADD UNIQUE KEY `unique_employe` (`employe_id`),
  ADD UNIQUE KEY `unique_user` (`user_id`);

--
-- Indexes for table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`document_id`);

--
-- Indexes for table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`employe_id`),
  ADD UNIQUE KEY `unique_user_emp` (`user_id`),
  ADD UNIQUE KEY `unique_cin` (`CIN`),
  ADD UNIQUE KEY `unique_email` (`email`);

--
-- Indexes for table `etapes`
--
ALTER TABLE `etapes`
  ADD PRIMARY KEY (`etape_id`);

--
-- Indexes for table `procedures`
--
ALTER TABLE `procedures`
  ADD PRIMARY KEY (`procedure_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chefs`
--
ALTER TABLE `chefs`
  MODIFY `chef_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `documents`
--
ALTER TABLE `documents`
  MODIFY `document_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `employes`
--
ALTER TABLE `employes`
  MODIFY `employe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `etapes`
--
ALTER TABLE `etapes`
  MODIFY `etape_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `procedures`
--
ALTER TABLE `procedures`
  MODIFY `procedure_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

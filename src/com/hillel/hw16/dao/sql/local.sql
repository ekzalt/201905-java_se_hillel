-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 04, 2019 at 02:52 PM
-- Server version: 5.6.37
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `local`
--

-- --------------------------------------------------------

--
-- Table structure for table `actors`
--

CREATE TABLE IF NOT EXISTS `actors` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `born` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actors`
--

INSERT INTO `actors` (`id`, `name`, `born`, `created_at`, `updated_at`) VALUES
(1, 'Robert Downey Jr.', '1965-04-04', '2019-07-28 14:57:58', '2019-07-28 14:57:58'),
(2, 'Chris Evans', '1981-06-13', '2019-07-28 14:57:58', '2019-07-28 14:57:58'),
(3, 'Terrence Howard', '1969-03-11', '2019-07-29 18:34:05', '2019-07-29 18:34:05'),
(4, 'Jeff Bridges', '1949-12-04', '2019-07-29 18:34:05', '2019-07-29 18:34:05'),
(5, 'Shaun Toub', '1963-04-06', '2019-07-29 18:36:09', '2019-07-29 18:36:09'),
(6, 'Gwyneth Paltrow', '1972-09-27', '2019-07-29 18:36:09', '2019-07-29 18:36:09'),
(7, 'Hugo Weaving', '1960-04-04', '2019-07-29 18:39:42', '2019-07-29 18:39:42'),
(8, 'Samuel L. Jackson', '1948-12-21', '2019-07-29 18:39:42', '2019-07-29 18:39:42'),
(9, 'Test Director Actor', '1980-01-07', '2019-08-04 11:52:36', '2019-08-04 11:52:36');

-- --------------------------------------------------------

--
-- Table structure for table `directors`
--

CREATE TABLE IF NOT EXISTS `directors` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `born` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `film_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `directors`
--

INSERT INTO `directors` (`id`, `name`, `born`, `created_at`, `updated_at`, `film_id`) VALUES
(1, 'Jon Favreau', '1966-10-19', '2019-07-28 15:08:18', '2019-07-28 15:08:18', 1),
(2, 'Joe Johnston', '1950-05-13', '2019-07-28 15:08:18', '2019-07-28 15:08:18', 2),
(3, 'Test Director Actor', '1980-01-07', '2019-08-04 11:45:37', '2019-08-04 11:45:37', 3);

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE IF NOT EXISTS `films` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `released` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `director_id` int(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id`, `name`, `country`, `released`, `created_at`, `updated_at`, `director_id`) VALUES
(1, 'Iron Man', 'USA', '2008-04-14', '2019-07-28 13:44:50', '2019-07-28 13:44:50', 1),
(2, 'Captain America: The First Avenger', 'USA', '2011-07-22', '2019-07-28 13:44:50', '2019-07-28 13:44:50', 2),
(3, 'Test film', 'USA', '2011-11-11', '2019-08-04 11:47:15', '2019-08-04 11:47:15', 3);

-- --------------------------------------------------------

--
-- Table structure for table `films_actors`
--

CREATE TABLE IF NOT EXISTS `films_actors` (
  `id` int(11) NOT NULL,
  `film_id` int(11) DEFAULT NULL,
  `actor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `films_actors`
--

INSERT INTO `films_actors` (`id`, `film_id`, `actor_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 2, 7),
(8, 2, 8),
(9, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `directors`
--
ALTER TABLE `directors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `films_actors`
--
ALTER TABLE `films_actors`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actors`
--
ALTER TABLE `actors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `directors`
--
ALTER TABLE `directors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `films_actors`
--
ALTER TABLE `films_actors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

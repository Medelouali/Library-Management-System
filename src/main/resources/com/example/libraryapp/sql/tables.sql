-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 12 nov. 2022 à 15:20
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS lib;
CREATE DATABASE lib;
USE lib;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `teste`
--

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `privileges` int(11) NOT NULL DEFAULT 2,
  `maxBorrowed` int(11) DEFAULT 10,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `admins`
--

INSERT INTO `admins` (`username`, `picture`, `email`, `password`, `cin`, `description`, `privileges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
('derek.reichel', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'yolanda.murphy@gaylord.biz', 't5Z[<.', 'EE123456', 'Laboriosam velit quia quia eligendi deserunt. Ut quis quam sapiente optio qui neque eos veniam. Dolores sequi nisi incidunt dolores distinctio soluta recusandae provident. Earum quam et error ullam distinctio voluptate. Ex sapiente excepturi qui.', 2, 3, 0, '2022-10-26 13:49:37'),
('wilderman.candido', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'julia72@yahoo.com', 'drZ:aJ+', 'EE123456', 'Aut maxime accusamus dignissimos suscipit ut tempora cumque reiciendis. Et quis aut odio quas quisquam excepturi. Nulla consequatur magnam rerum repudiandae. Voluptatem voluptatem sunt rem deserunt minima sit non. Quas enim nesciunt rerum cumque occaecati quod. Quibusdam magnam recusandae inventore dolores magnam iusto a sunt. Sed dolorem vel est adipisci voluptatem id.', 2, 3, 1, '2022-10-26 13:49:37'),
('cronin.amelia', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'witting.shaniya@gmail.com', 'AF|%Z2w/,+1.lbI', 'EE123456', 'Nesciunt esse ut possimus nemo nulla consectetur. Et adipisci veritatis at. Repudiandae a incidunt et pariatur debitis sit. Molestiae harum voluptatum et neque quia soluta. Recusandae fugit cum mollitia occaecati tempore impedit enim fuga. Ullam corporis labore neque incidunt. Voluptatum tenetur consequuntur incidunt maiores in.', 2, 3, 1, '2022-10-26 13:49:37'),
('schaden.lowell', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'treutel.okey@yahoo.com', 'DQ>SzH&K;My&`|8g', 'EE123456', 'Veniam earum vel et. Ipsa repudiandae dolorem corrupti ab modi. Sit pariatur ipsam aliquam dolorem quis repudiandae. Modi ea quia quibusdam dolor est quisquam rerum.', 2, 3, 0, '2022-10-26 13:49:37'),
('farrell.mozelle', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'claude18@mann.com', 'Yw*aE?', 'EE123456', 'Aut et reprehenderit distinctio facilis. Exercitationem cum cupiditate facere libero ipsum. Doloribus sit est hic ut unde. Atque quibusdam maiores tempora architecto qui. Quos ut qui qui. Atque inventore perspiciatis placeat non autem. Ad corrupti omnis repellendus odio culpa itaque adipisci.', 2, 3, 0, '2022-10-26 13:49:37');

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE `books` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `edition` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `isbn` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rating` DECIMAL(6,2)  DEFAULT 0.0,
  `language` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isDeleted` tinyint(1) DEFAULT 0,
  `copyAmount` bigint(20) NOT NULL DEFAULT 0,
  `datePub` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `books`
--

INSERT INTO `books` (`title`, `author`, `picture`, `genre`, `edition`, `isbn`, `rating`, `language`, `isDeleted`, `copyAmount`, `datePub`) VALUES
('Harry Potter', 'J.K.R', '/com/example/libraryapp/assets/book3.jpg', 'Fiction,Crime,Psychological', 'eveniet', 123269512, 5, 'mi', 1, 5, "2009"),
('Et blanditiis placeat cupiditate pariatur natus consectetur.', '/com/example/libraryapp/assets/book4.jpg', 'Dr. Nico Lehner', 'Fiction,Crime,Psychological', 'dolorem', 123269512, 5, 'gd', 0, 5,  "2010"),
('Beatae voluptatem possimus rerum est quos ut.', 'Billy Lebsack', '/com/example/libraryapp/assets/book3.jpg', 'Fiction,Crime,Psychological', 'at', 123269512, 5, 'ch', 1, 5,  "2011"),
('Perspiciatis culpa natus dolores.', 'Orland Dach', '/com/example/libraryapp/assets/book1.jpg', 'Fiction,Crime,Psychological', 'dignissimos', 123269512, 5, 'or', 1, 5,  "2002"),
('Enim non consequatur soluta dolor tempore consequatur nostrum.', 'Miss Abby Cartwright', '/com/example/libraryapp/assets/book4.jpg', 'Fiction,Crime,Psychological', 'qui', 123269512, 5, 'jv', 0, 5,  "2022");

-- --------------------------------------------------------

--
-- Structure de la table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `privileges` int(11) DEFAULT 3,
  `maxBorrowed` int(11) DEFAULT 20,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `students`
--

INSERT INTO `students` (`username`, `email`, `password`, `cin`, `description`, `privileges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
('kirlin.laurence', 'romaguera.maritza@russel.com', '!EMo79:|2g*8h}', 'EE15469', 'Dolores dignissimos in ut laborum officiis repudiandae. Saepe fugit dolor eius eum voluptatem commodi minima. Delectus veritatis rerum qui dolor. Velit et est cumque repellat quos reprehenderit numquam. Sed ullam sed libero ea voluptatem velit eaque.', 1, 3, 0, '2022-10-26 13:49:37'),
('adriana48', 'charlotte.farrell@hotmail.com', 'OiHA0/gGE+dRSv@', 'EE15469', 'Unde dolore blanditiis vero vel velit est ea aperiam. Et dolor commodi et fugit nemo iste deserunt. Numquam quae minima in quo hic. Natus quis minus est.', 1, 3, 0, '2022-10-26 13:49:37'),
('kbogan', 'brooks78@purdy.net', 'QG_KSBf_Z,', 'EE15469', 'Temporibus et dolor natus quasi sed. Voluptas nemo non hic deleniti quasi dolorum modi. Perspiciatis nulla fugiat consectetur laboriosam occaecati. Voluptas et aut dolor inventore.', 1, 3, 0, '2022-10-26 13:49:37'),
('edyth.frami', 'jacynthe39@franecki.com', 'f-<jJJI=LO?.]?8(uf', 'EE15469', 'Magni et sequi doloribus qui alias at maxime. Nobis vero aut aut ipsa. Nemo rerum molestias distinctio. Minus libero magni tenetur et quasi. Sequi qui cupiditate quia tempore. Tempora amet tenetur dolores dolores voluptatem.', 1, 3, 0, '2022-10-26 13:49:37'),
('arvid19', 'hermiston.hilda@yahoo.com', 'N3CniC@}`DN:{Fw6', 'EE15469', 'Optio ullam id itaque. Atque mollitia molestiae velit omnis ullam error vero. Dolore doloremque est sed laboriosam pariatur quis. Quia eos omnis dolores aut. Nobis cumque dolores maxime quae unde ullam ea deleniti.', 1, 3, 0, '2022-10-26 13:49:37');

-- --------------------------------------------------------
--
-- Structure de la table `bookcopies`
--

CREATE TABLE `bookcopies` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) UNSIGNED NOT NULL,
  `state` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'good',
  `availability` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT 'available',
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (id),
  FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `bookcopies`
--

INSERT INTO `bookcopies` (`book_id`, `state`, `availability`, `timestamp`) VALUES
(1, 'good', 'available', '2022-11-12 14:16:39'),
(2, NULL, 'unavailable', '2022-11-12 14:17:11'),
(3, 'bad', 'available', '2022-11-12 14:17:34');

-- --------------------------------------------------------
--
-- Structure de la table `borrowings`
--

CREATE TABLE `borrowings` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) UNSIGNED NOT NULL,
  `copy_id` bigint(20) UNSIGNED NOT NULL,
  `admin_id` bigint(20) UNSIGNED NOT NULL,
  `borrowingDate` timestamp NULL DEFAULT NULL,
  `returnDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
  FOREIGN KEY (copy_id) REFERENCES bookcopies(id) ON DELETE CASCADE,
  FOREIGN KEY (admin_id) REFERENCES admins(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `borrowings`
--

INSERT INTO `borrowings` (`student_id`, `copy_id`, `admin_id`, `borrowingDate`, `returnDate`) VALUES
(1, 1, 3, '2022-11-01 14:17:53', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `notifications`
--

CREATE TABLE `notifications` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) UNSIGNED NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `timeToLive` bigint(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `isSeen` tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `notifications`
--

INSERT INTO `notifications` (`student_id`, `content`, `timeToLive`, `timestamp`, `isSeen`) VALUES
(3, 'Give me back my book ', 1000, '2022-11-12 14:19:26', 0);

-- --------------------------------------------------------

--
-- Structure de la table `superadmins`
--

CREATE TABLE `superadmins` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `privileges` int(11) NOT NULL,
  `maxBorrowed` int(11) DEFAULT NULL,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `superadmins`
--

INSERT INTO `superadmins` (`username`, `picture`, `email`, `password`, `cin`, `description`, `privileges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
('superadmin', 'https://via.placeholder.com/640x480.png/003311?text=mollitia', 'superadmin@email.com', '12az55sd', 'EE789654', 'Delectus qui qui porro sed animi sapiente sit. Voluptas veritatis odit hic totam quis. Eaque ea qui voluptate est molestias.', 3, NULL, NULL, '2022-10-26 13:49:37');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
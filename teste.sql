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
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `priveleges` int(11) NOT NULL,
  `maxBorrowed` int(11) NOT NULL,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `admins`
--

INSERT INTO `admins` (`id`, `username`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'derek.reichel', 'yolanda.murphy@gaylord.biz', 't5Z[<.', 'EE123456', 'Laboriosam velit quia quia eligendi deserunt. Ut quis quam sapiente optio qui neque eos veniam. Dolores sequi nisi incidunt dolores distinctio soluta recusandae provident. Earum quam et error ullam distinctio voluptate. Ex sapiente excepturi qui.', 2, 3, 0, '2022-10-26 13:49:37'),
(2, 'wilderman.candido', 'julia72@yahoo.com', 'dr\\Z:aJ+', 'EE123456', 'Aut maxime accusamus dignissimos suscipit ut tempora cumque reiciendis. Et quis aut odio quas quisquam excepturi. Nulla consequatur magnam rerum repudiandae. Voluptatem voluptatem sunt rem deserunt minima sit non. Quas enim nesciunt rerum cumque occaecati quod. Quibusdam magnam recusandae inventore dolores magnam iusto a sunt. Sed dolorem vel est adipisci voluptatem id.', 2, 3, 1, '2022-10-26 13:49:37'),
(3, 'cronin.amelia', 'witting.shaniya@gmail.com', 'AF|%Z\"2w/,+1.lbI', 'EE123456', 'Nesciunt esse ut possimus nemo nulla consectetur. Et adipisci veritatis at. Repudiandae a incidunt et pariatur debitis sit. Molestiae harum voluptatum et neque quia soluta. Recusandae fugit cum mollitia occaecati tempore impedit enim fuga. Ullam corporis labore neque incidunt. Voluptatum tenetur consequuntur incidunt maiores in.', 2, 3, 1, '2022-10-26 13:49:37'),
(4, 'schaden.lowell', 'treutel.okey@yahoo.com', 'DQ2\\>S!\\zH&K;My&`|8g', 'EE123456', 'Veniam earum vel et. Ipsa repudiandae dolorem corrupti ab modi. Sit pariatur ipsam aliquam dolorem quis repudiandae. Modi ea quia quibusdam dolor est quisquam rerum.', 2, 3, 0, '2022-10-26 13:49:37'),
(5, 'farrell.mozelle', 'claude18@mann.com', 'Yw*\'aE?', 'EE123456', 'Aut et reprehenderit distinctio facilis. Exercitationem cum cupiditate facere libero ipsum. Doloribus sit est hic ut unde. Atque quibusdam maiores tempora architecto qui. Quos ut qui qui. Atque inventore perspiciatis placeat non autem. Ad corrupti omnis repellendus odio culpa itaque adipisci.', 2, 3, 0, '2022-10-26 13:49:37');

-- --------------------------------------------------------

--
-- Structure de la table `bookcopies`
--

CREATE TABLE `bookcopies` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `book_id` bigint(20) UNSIGNED NOT NULL,
  `state` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `availability` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `bookcopies`
--

INSERT INTO `bookcopies` (`id`, `book_id`, `state`, `availability`, `timestamp`) VALUES
(1, 1, 'good', 'available', '2022-11-12 14:16:39'),
(2, 2, NULL, 'unavailable', '2022-11-12 14:17:11'),
(3, 3, 'bad', 'available', '2022-11-12 14:17:34');

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE `books` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genre` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `edition` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isbn` bigint(20) NOT NULL,
  `Rating` int(11) NOT NULL,
  `language` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL,
  `copyAmount` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `books`
--

INSERT INTO `books` (`id`, `title`, `author`, `genre`, `edition`, `isbn`, `Rating`, `language`, `IsDeleted`, `copyAmount`) VALUES
(1, 'Explicabo voluptas est aspernatur rem dignissimos quas.', 'Dayton Halvorson DVM', 'Fiction,Crime,Psychological', 'eveniet', 123269512, 5, 'mi', 1, 5),
(2, 'Et blanditiis placeat cupiditate pariatur natus consectetur.', 'Dr. Nico Lehner', 'Fiction,Crime,Psychological', 'dolorem', 123269512, 5, 'gd', 0, 5),
(3, 'Beatae voluptatem possimus rerum est quos ut.', 'Billy Lebsack', 'Fiction,Crime,Psychological', 'at', 123269512, 5, 'ch', 1, 5),
(4, 'Perspiciatis culpa natus dolores.', 'Orland Dach', 'Fiction,Crime,Psychological', 'dignissimos', 123269512, 5, 'or', 1, 5),
(5, 'Enim non consequatur soluta dolor tempore consequatur nostrum.', 'Miss Abby Cartwright', 'Fiction,Crime,Psychological', 'qui', 123269512, 5, 'jv', 0, 5);

-- --------------------------------------------------------

--
-- Structure de la table `borrowings`
--

CREATE TABLE `borrowings` (
  `student_id` bigint(20) UNSIGNED NOT NULL,
  `copy_id` bigint(20) UNSIGNED NOT NULL,
  `admin_id` bigint(20) UNSIGNED NOT NULL,
  `borrowingDate` timestamp NULL DEFAULT NULL,
  `returnDate` timestamp NULL DEFAULT NULL
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
  `id` bigint(20) UNSIGNED NOT NULL,
  `student_id` bigint(20) UNSIGNED NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `timeToLive` bigint(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `isSeen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `notifications`
--

INSERT INTO `notifications` (`id`, `student_id`, `content`, `timeToLive`, `timestamp`, `isSeen`) VALUES
(1, 3, 'Give me back my book ', 1000, '2022-11-12 14:19:26', 0);

-- --------------------------------------------------------

--
-- Structure de la table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `priveleges` int(11) NOT NULL,
  `maxBorrowed` int(11) NOT NULL,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `students`
--

INSERT INTO `students` (`id`, `username`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'kirlin.laurence', 'romaguera.maritza@russel.com', '!EMo79:|2g*8h}', 'EE15469', 'Dolores dignissimos in ut laborum officiis repudiandae. Saepe fugit dolor eius eum voluptatem commodi minima. Delectus veritatis rerum qui dolor. Velit et est cumque repellat quos reprehenderit numquam. Sed ullam sed libero ea voluptatem velit eaque.', 1, 3, 0, '2022-10-26 13:49:37'),
(2, 'adriana48', 'charlotte.farrell@hotmail.com', 'Oi\\rHA0/gGE+dRSv@', 'EE15469', 'Unde dolore blanditiis vero vel velit est ea aperiam. Et dolor commodi et fugit nemo iste deserunt. Numquam quae minima in quo hic. Natus quis minus est.', 1, 3, 0, '2022-10-26 13:49:37'),
(3, 'kbogan', 'brooks78@purdy.net', 'QG_KSBf_Z,', 'EE15469', 'Temporibus et dolor natus quasi sed. Voluptas nemo non hic deleniti quasi dolorum modi. Perspiciatis nulla fugiat consectetur laboriosam occaecati. Voluptas et aut dolor inventore.', 1, 3, 0, '2022-10-26 13:49:37'),
(4, 'edyth.frami', 'jacynthe39@franecki.com', 'f-<jJ\'JI=LO?.]?8(uf', 'EE15469', 'Magni et sequi doloribus qui alias at maxime. Nobis vero aut aut ipsa. Nemo rerum molestias distinctio. Minus libero magni tenetur et quasi. Sequi qui cupiditate quia tempore. Tempora amet tenetur dolores dolores voluptatem.', 1, 3, 0, '2022-10-26 13:49:37'),
(5, 'arvid19', 'hermiston.hilda@yahoo.com', 'N3CniC@}`F\\DN:{Fw6', 'EE15469', 'Optio ullam id itaque. Atque mollitia molestiae velit omnis ullam error vero. Dolore doloremque est sed laboriosam pariatur quis. Quia eos omnis dolores aut. Nobis cumque dolores maxime quae unde ullam ea deleniti.', 1, 3, 0, '2022-10-26 13:49:37');

-- --------------------------------------------------------

--
-- Structure de la table `superadmins`
--

CREATE TABLE `superadmins` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cin` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `priveleges` int(11) NOT NULL,
  `maxBorrowed` int(11) DEFAULT NULL,
  `flagged` int(11) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `superadmins`
--

INSERT INTO `superadmins` (`id`, `username`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'superadmin', 'superadmin@email.com', '12az55sd', 'EE789654', 'Delectus qui qui porro sed animi sapiente sit. Voluptas veritatis odit hic totam quis. Eaque ea qui voluptate est molestias.', 3, NULL, NULL, '2022-10-26 13:49:37');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bookcopies`
--
ALTER TABLE `bookcopies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookcopies_book_id_foreign` (`book_id`);

--
-- Index pour la table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `borrowings`
--
ALTER TABLE `borrowings`
  ADD KEY `borrowings_student_id_foreign` (`student_id`),
  ADD KEY `borrowings_copy_id_foreign` (`copy_id`),
  ADD KEY `borrowings_admin_id_foreign` (`admin_id`);

--
-- Index pour la table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `notifications_student_id_foreign` (`student_id`);

--
-- Index pour la table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `superadmins`
--
ALTER TABLE `superadmins`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `bookcopies`
--
ALTER TABLE `bookcopies`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `books`
--
ALTER TABLE `books`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `students`
--
ALTER TABLE `students`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `superadmins`
--
ALTER TABLE `superadmins`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bookcopies`
--
ALTER TABLE `bookcopies`
  ADD CONSTRAINT `bookcopies_book_id_foreign` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `borrowings`
--
ALTER TABLE `borrowings`
  ADD CONSTRAINT `borrowings_admin_id_foreign` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `borrowings_copy_id_foreign` FOREIGN KEY (`copy_id`) REFERENCES `bookcopies` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `borrowings_student_id_foreign` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_student_id_foreign` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

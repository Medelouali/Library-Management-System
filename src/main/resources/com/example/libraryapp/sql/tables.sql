-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 05 déc. 2022 à 22:01
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
-- Base de données : `tables`
--

-- --------------------------------------------------------

--
-- Structure de la table `admins`
--

CREATE TABLE `admins` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
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

INSERT INTO `admins` (`id`, `fullname`, `picture`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'hegmann.ena', 'https://via.placeholder.com/640x480.png/000033?text=temporibus', 'marvin.bernadette@yahoo.com', '_aZ]rFS', 'EE123456', 'Animi sunt aut doloribus iste quisquam. Consequatur autem quidem nihil sunt quo sed maxime maiores. Mollitia fugit eligendi minima autem. Inventore fugit dicta excepturi et ipsa doloremque. Quidem culpa omnis vel voluptatem corporis accusamus eum. Facere commodi magnam adipisci est.', 2, 3, 1, '2022-12-05 20:56:00'),
(2, 'daron51', 'https://via.placeholder.com/640x480.png/004444?text=voluptatibus', 'carmine56@hotmail.com', 'I6|iD6I', 'EE123456', 'Amet laudantium porro nemo quidem dolores ea dolore. Quidem molestiae odit est eos molestiae qui labore. Consectetur rerum aspernatur totam. Nemo ipsam repellendus aut officiis molestiae corporis consectetur. Provident dicta perspiciatis quia est vel eum. Necessitatibus ipsum explicabo iste voluptas ipsa veniam.', 2, 3, 0, '2022-12-05 20:56:00'),
(3, 'jhand', 'https://via.placeholder.com/640x480.png/0055ff?text=a', 'willard.heaney@conroy.net', '/0%/2A3uP9;', 'EE123456', 'Ad id nostrum placeat qui sed porro. Voluptas et cum incidunt voluptas vel debitis. Accusantium quod ea voluptas eaque. Est deleniti nobis laborum cum omnis sint.', 2, 3, 0, '2022-12-05 20:56:00'),
(4, 'vkassulke', 'https://via.placeholder.com/640x480.png/005577?text=quia', 'ruby36@wehner.net', '#wy0TW*{xb^*UD&', 'EE123456', 'Sit asperiores natus molestias. Est quam quia sed enim esse voluptas aut. Dolor rerum minima adipisci molestiae adipisci qui molestiae. Voluptates accusamus dolorem quae saepe in. Repellat voluptatem voluptatum maxime nobis reprehenderit voluptatum in. Autem cumque quia necessitatibus cumque temporibus.', 2, 3, 1, '2022-12-05 20:56:00'),
(5, 'carlie.herzog', 'https://via.placeholder.com/640x480.png/001166?text=sit', 'zbradtke@huel.info', 'f<_=Pp9LA.B', 'EE123456', 'Fuga incidunt eius reiciendis et molestiae voluptas. Vel dolorem libero magni vel voluptates expedita. Quam excepturi eius aut. Corporis temporibus quo dolorem ab et id. Saepe velit saepe rerum itaque. Dolor ut sit ea reiciendis. Voluptas ipsa dolor aspernatur non.', 2, 3, 1, '2022-12-05 20:56:00');

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
(1, 1, 'good', 'available', '2022-11-12 13:16:39'),
(2, 2, NULL, 'unavailable', '2022-11-12 13:17:11'),
(3, 3, 'bad', 'available', '2022-11-12 13:17:34');

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE `books` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
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

INSERT INTO `books` (`id`, `title`, `picture`, `author`, `genre`, `edition`, `isbn`, `Rating`, `language`, `IsDeleted`, `copyAmount`) VALUES
(1, 'Aut pariatur omnis autem rem accusantium.', 'https://via.placeholder.com/640x480.png/0088aa?text=hic', 'Ricky Langworth II', 'Fiction,Crime,Psychological', 'omnis', 123269512, 5, 'fi', 0, 5),
(2, 'Possimus incidunt et quaerat aut non assumenda.', 'https://via.placeholder.com/640x480.png/0088bb?text=totam', 'Darryl Reichel', 'Fiction,Crime,Psychological', 'repellendus', 123269512, 5, 'nl', 1, 5),
(3, 'Omnis earum facilis optio alias ea non et.', 'https://via.placeholder.com/640x480.png/00ddaa?text=distinctio', 'Lulu West', 'Fiction,Crime,Psychological', 'dolor', 123269512, 5, 'uk', 0, 5),
(4, 'Dolores id iure ut amet delectus.', 'https://via.placeholder.com/640x480.png/00bb11?text=debitis', 'Justus Moore', 'Fiction,Crime,Psychological', 'modi', 123269512, 5, 'tg', 1, 5),
(5, 'Amet odio assumenda voluptatem qui.', 'https://via.placeholder.com/640x480.png/00aaee?text=et', 'Mr. Mohammed Kozey', 'Fiction,Crime,Psychological', 'harum', 123269512, 5, 'mn', 1, 5);

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
(1, 1, 3, '2022-11-01 13:17:53', NULL);

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
(1, 3, 'Give me back my book ', 1000, '2022-11-12 13:19:26', 0);

-- --------------------------------------------------------

--
-- Structure de la table `students`
--

CREATE TABLE `students` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
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

INSERT INTO `students` (`id`, `fullname`, `picture`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'jolie.carter', 'https://via.placeholder.com/640x480.png/007700?text=natus', 'patience62@gutmann.com', 'k8d-\'2(=kwS_*@^AE>k', 'EE15469', 'Quibusdam iste autem iste tempora magni ut deserunt. Blanditiis natus dolorem et doloremque molestiae. Voluptatem voluptatem animi sit et eos ipsam voluptate. Consequatur voluptatem necessitatibus et. Quia mollitia voluptas et voluptatibus totam. Ipsa enim delectus ea dicta dolores.', 1, 3, 0, '2022-12-05 20:56:00'),
(2, 'crystel.kassulke', 'https://via.placeholder.com/640x480.png/00aa11?text=blanditiis', 'posinski@lang.com', '=!cP|vE|Sv]=#Mw&zp\\', 'EE15469', 'Ab fugiat sunt officiis ea quos facere. Distinctio corporis sint dolore ut sunt. Officiis excepturi eveniet eos temporibus. Accusamus aut et ipsum voluptatibus exercitationem praesentium. Earum voluptates dolores eos error quibusdam. Maiores dolores occaecati corporis omnis non dolorem dolor cupiditate.', 1, 3, 1, '2022-12-05 20:56:00'),
(3, 'rice.josiane', 'https://via.placeholder.com/640x480.png/00ff11?text=maiores', 'davion89@ohara.org', 'H>Irh4e[6G>GTk', 'EE15469', 'Fugit et dicta eligendi inventore tenetur dolorem nesciunt voluptatem. Eum temporibus aut est doloribus quam illo. Reiciendis blanditiis facilis exercitationem ut deleniti et ab. Voluptas asperiores officiis reprehenderit consequuntur. Nesciunt et modi nostrum provident tempore consequatur.', 1, 3, 1, '2022-12-05 20:56:00'),
(4, 'vmohr', 'https://via.placeholder.com/640x480.png/0055ee?text=laudantium', 'qbechtelar@yahoo.com', 'rl\"LWh', 'EE15469', 'Ipsa maiores voluptatem incidunt blanditiis quaerat laboriosam sunt nulla. Est est vel nobis corrupti. Cupiditate quaerat perferendis consequatur quo exercitationem ut aspernatur. Cupiditate aut quibusdam nemo aut.', 1, 3, 1, '2022-12-05 20:56:00'),
(5, 'elbert89', 'https://via.placeholder.com/640x480.png/0066bb?text=enim', 'will.stan@feil.com', 'im\"gFLyZfAF}U@8', 'EE15469', 'Eveniet sint et dolorum tempora id dolore ipsum. Provident et assumenda esse nemo. Velit sit quaerat similique non. Magnam odit nam modi quidem. Odio sapiente quisquam dolorem sed. Vel possimus doloribus totam earum. Aperiam sapiente debitis reiciendis doloribus nostrum.', 1, 3, 0, '2022-12-05 20:56:00');

-- --------------------------------------------------------

--
-- Structure de la table `superadmins`
--

CREATE TABLE `superadmins` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
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

INSERT INTO `superadmins` (`id`, `fullname`, `picture`, `email`, `password`, `cin`, `description`, `priveleges`, `maxBorrowed`, `flagged`, `timestamp`) VALUES
(1, 'superadmin', 'https://via.placeholder.com/640x480.png/003311?text=mollitia', 'superadmin@email.com', '12az55sd', 'EE789654', 'Cumque deserunt aspernatur nam ad consequatur veniam dolores. At assumenda autem id qui. Minus accusantium ipsa officia deserunt sequi. Ut harum voluptates cumque dolor ea sint doloremque. Totam magni quidem fugiat consequatur.', 3, NULL, NULL, '2022-12-05 20:56:00');

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

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Jan 2023 pada 09.59
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_sampah_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `accounts`
--

CREATE TABLE `accounts` (
    `id` int(11) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `phone_number` varchar(255) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `accounts`
--

INSERT INTO `accounts` VALUES
    (1, '', 'nurikhsan.0203@gmail.com', 'Nur Ikhsan ', 'aku123', ''),
    (2, '', 'imannurfaizi33@gmail.com', 'Iman Nurfaizi', 'k4r4k4t4u', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `locations`
--

CREATE TABLE `locations` (
    `id` int(11) NOT NULL,
    `address` varchar(255) NOT NULL,
    `close_time` time NOT NULL,
    `contacts` varchar(255) NOT NULL,
    `latitute` double NOT NULL,
    `longitute` double NOT NULL,
    `name` varchar(255) NOT NULL,
    `open_time` time NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `locations`
--

INSERT INTO `locations` VALUES
    (1, 'Jl. Taman Siswa No. 1', '16:00:00', '081234567890', -7.815705, 110.376437, 'Bank Sampah 1', '08:00:00'),
    (2, 'Jl. K.Laut Samadikun', '15:00:00', '081234599890', -7.802687, 110.374045, 'Bank Sampah 2', '09:00:00'),
    (3, 'Jl. Bintaran Kulon', '15:30:00', '081234599880', -7.802214, 110.37271, 'Bank Sampah 3', '09:40:00'),
    (4, 'Jl. Sriwedani', '17:00:00', '083234599880', -7.801222, 110.368242, 'Bank Sampah 4', '08:45:00'),
    (5, 'Jl. Kapas', '17:00:00', '083234599820', -7.800133, 110.383263, 'Bank Sampah 5', '09:00:00'),
    (6, 'Jl. Sidomukti', '15:30:00', '083234569825', -7.798908, 110.39983, 'Bank Sampah 6', '07:30:00'),
    (7, 'Jl. Timoho', '17:00:00', '085234569825', -7.796271, 110.391889, 'Bank Sampah 7', '07:30:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `storing_trashes`
--

CREATE TABLE `storing_trashes` (
    `id` int(11) NOT NULL,
    `created_at` datetime NOT NULL,
    `status` varchar(255) DEFAULT NULL,
    `total` bigint(20) DEFAULT NULL,
    `weight` int(11) DEFAULT NULL,
    `account_id` int(11) NOT NULL,
    `location_id` int(11) NOT NULL,
    `trash_id` int(11) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `storing_trashes`
--

INSERT INTO `storing_trashes` VALUES
    (1, '2023-01-15 14:17:36', 'Selesai', 7000, 2, 1, 1, 3),
    (2, '2023-01-15 14:21:45', 'Selesai', 25000, 5, 1, 3, 1),
    (3, '2023-01-15 14:22:29', 'Selesai', 11000, 2, 1, 1, 4),
    (4, '2023-01-15 14:23:10', 'Dibatalkan', 55000, 10, 1, 4, 4),
    (5, '2023-01-15 14:24:42', 'Selesai', 750000, 100, 1, 5, 5),
    (6, '2023-01-15 14:31:47', 'Selesai', 5000, 1, 1, 1, 1),
    (7, '2023-01-15 14:33:58', 'Selesai', 110000, 22, 1, 1, 1),
    (8, '2023-01-15 14:41:41', 'Dibatalkan', 10000, 2, 1, 7, 1),
    (9, '2023-01-15 14:52:07', 'DalamProses', 375000, 50, 1, 6, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `trash`
--

CREATE TABLE `trash` (
    `id` int(11) NOT NULL,
    `description` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `price` bigint(20) NOT NULL,
    `image_id` int(11) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `trash`
--

INSERT INTO `trash` VALUES
    (1, 'Botol Plastik', 'Botal Plastik', 5000, 1),
    (2, 'Botol Kaca', 'Botal Kaca', 6000, 2),
    (3, 'Kaleng', 'Kaleng', 3500, 3),
    (4, 'Kertas Koran', 'Kertas Koran', 5500, 4),
    (5, 'Logam', 'Logam', 7500, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `trash_images`
--

CREATE TABLE `trash_images` (
    `id` int(11) NOT NULL,
    `name` varchar(255) NOT NULL,
    `size` bigint(20) NOT NULL,
    `type` varchar(255) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `trash_images`
--

INSERT INTO `trash_images` VALUES
    (1, '6187de40-a295-4631-8511-090dd8242bcd.jpeg', 52381, 'image/jpeg'),
    (2, '8bcd91bb-c92e-45d6-8f37-41e8d7405525.jpeg', 57368, 'image/jpeg'),
    (3, '4e572fac-8735-4d0d-bb97-122e3e4e57c1.jpeg', 110785, 'image/jpeg'),
    (4, 'd10f3a48-04f7-495f-9a1d-fa59c3bc528b.jpeg', 67247, 'image/jpeg'),
    (5, '3d33cfff-b1d7-48c0-b895-66fe60da406d.jpeg', 123555, 'image/jpeg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `accounts`
--
ALTER TABLE `accounts`
    ADD PRIMARY KEY (`id`),
    ADD UNIQUE KEY `UK_n7ihswpy07ci568w34q0oi8he` (`email`);

--
-- Indeks untuk tabel `locations`
--
ALTER TABLE `locations`
    ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `storing_trashes`
--
ALTER TABLE `storing_trashes`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKq5e45b56tbbsqubnld06mpsff` (`account_id`),
    ADD KEY `FK396h9q4rurnbqodxt4tucwc8u` (`location_id`),
    ADD KEY `FKo0ie2o03rubwi2oor7a2tcr3p` (`trash_id`);

--
-- Indeks untuk tabel `trash`
--
ALTER TABLE `trash`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKiepdf9tyfedmamglvobu4qyxv` (`image_id`);

--
-- Indeks untuk tabel `trash_images`
--
ALTER TABLE `trash_images`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `accounts`
--
ALTER TABLE `accounts`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `locations`
--
ALTER TABLE `locations`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `storing_trashes`
--
ALTER TABLE `storing_trashes`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `trash`
--
ALTER TABLE `trash`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `trash_images`
--
ALTER TABLE `trash_images`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `storing_trashes`
--
ALTER TABLE `storing_trashes`
    ADD CONSTRAINT `FK396h9q4rurnbqodxt4tucwc8u` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`),
    ADD CONSTRAINT `FKo0ie2o03rubwi2oor7a2tcr3p` FOREIGN KEY (`trash_id`) REFERENCES `trash` (`id`),
    ADD CONSTRAINT `FKq5e45b56tbbsqubnld06mpsff` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`);

--
-- Ketidakleluasaan untuk tabel `trash`
--
ALTER TABLE `trash`
    ADD CONSTRAINT `FKiepdf9tyfedmamglvobu4qyxv` FOREIGN KEY (`image_id`) REFERENCES `trash_images` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

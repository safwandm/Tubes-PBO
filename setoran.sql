-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 05, 2025 at 02:35 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `setoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `motor`
--

CREATE TABLE `motor` (
  `id_motor` int(11) NOT NULL,
  `plat_nomor` char(10) NOT NULL,
  `brand` varchar(15) NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `tahun` char(4) NOT NULL,
  `transmisi` varchar(10) NOT NULL,
  `status_motor` varchar(10) NOT NULL,
  `silinder` int(3) NOT NULL,
  `harga_harian` int(11) NOT NULL,
  `id_pemilik` int(11) DEFAULT NULL,
  `deleted` varchar(5) DEFAULT 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `motor`
--

INSERT INTO `motor` (`id_motor`, `plat_nomor`, `brand`, `tipe`, `tahun`, `transmisi`, `status_motor`, `silinder`, `harga_harian`, `id_pemilik`, `deleted`) VALUES
(1, 'B 1234 ABC', 'Yamaha', 'NMAX 155', '2020', 'Matic', 'Tersedia', 155, 55000, 5, 'false'),
(2, 'D 5678 DEF', 'Honda', 'CBR 150R', '2019', 'Manual', 'Tersedia', 150, 60000, 8, 'false'),
(3, 'F 9101 GHI', 'Suzuki', 'GSX-R150', '2021', 'Manual', 'Disewa', 150, 60000, 9, 'false'),
(4, 'T 9101 GHI', 'Suzuki', 'Address', '2021', 'Matic', 'Disewa', 115, 45000, 10, 'false'),
(5, 'F 1234 JKL', 'Yamaha', 'Aerox 155', '2022', 'Matic', 'Tersedia', 155, 55000, 11, 'false'),
(6, 'Z 5678 MNO', 'Honda', 'Beat', '2018', 'Matic', 'Tersedia', 110, 45000, 3, 'false'),
(7, 'B 9101 PQR', 'Honda', 'PCX 150', '2021', 'Matic', 'Disewa', 150, 55000, 5, 'false'),
(8, 'D 1234 STU', 'Yamaha', 'Mio M3', '2020', 'Matic', 'Disewa', 125, 45000, 8, 'false'),
(24, '12', '12', '12', '1220', 'Manual', 'Tersedia', 120, 40000, 3, 'false');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_motor` int(11) DEFAULT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `nominal` int(11) NOT NULL,
  `status_transaksi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_motor`, `tanggal_mulai`, `tanggal_selesai`, `nominal`, `status_transaksi`) VALUES
(31, 13, 4, '2024-06-20', '2024-06-21', 90000, 'selesai'),
(33, 13, 6, '2024-06-12', '2024-06-14', 135000, 'selesai'),
(35, 13, 6, '2024-06-20', '2024-06-22', 135000, 'selesai'),
(36, 13, 6, '2024-06-12', '2024-06-13', 90000, 'selesai'),
(37, 13, 8, '2024-06-28', '2024-06-29', 90000, 'selesai'),
(39, 4, 23, '2024-06-19', '2024-06-20', 80000, 'selesai'),
(40, 13, 4, '2024-06-12', '2024-06-14', 135000, 'aktif'),
(41, 4, 8, '2025-03-05', '2025-03-07', 135000, 'selesai');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `umur` int(11) NOT NULL,
  `tipe_akun` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `umur`, `tipe_akun`) VALUES
(3, 'yoga', 'cek', 20, 'Mitra'),
(4, 'andriyani27', 'pass1234', 24, 'Pelanggan'),
(5, 'bambang_putra', 'securepass456', 30, 'Mitra'),
(6, 'cindywati', 'password789', 22, 'Pelanggan'),
(7, 'dian_novita', 'qwerty321', 19, 'Pelanggan'),
(8, 'edwinarah', 'letmein987', 26, 'Mitra'),
(9, 'fatimah_sari', 'iloveyou654', 28, 'Mitra'),
(10, 'gilang_perdana', 'raket123', 35, 'Mitra'),
(11, 'haryanto99', 'monkeypass', 33, 'Mitra'),
(12, 'intanputri', 'sunshine777', 21, 'Pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `vu_join_transaksi_motor`
--

CREATE TABLE `vu_join_transaksi_motor` (
  `id_transaksi` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_motor` int(11) DEFAULT NULL,
  `id_pemilik` int(11) DEFAULT NULL,
  `tanggal_mulai` date DEFAULT NULL,
  `tanggal_selesai` date DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vu_transaksi_nama_motor`
--

CREATE TABLE `vu_transaksi_nama_motor` (
  `id_transaksi` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_pemilik` int(11) DEFAULT NULL,
  `id_motor` int(11) DEFAULT NULL,
  `tanggal_mulai` date DEFAULT NULL,
  `tanggal_selesai` date DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `nama_motor` varchar(66) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `motor`
--
ALTER TABLE `motor`
  ADD PRIMARY KEY (`id_motor`),
  ADD KEY `id_pemilik` (`id_pemilik`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `FK_id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `motor`
--
ALTER TABLE `motor`
  MODIFY `id_motor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `motor`
--
ALTER TABLE `motor`
  ADD CONSTRAINT `FK1` FOREIGN KEY (`id_pemilik`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

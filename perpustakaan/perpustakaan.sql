-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2023 at 03:15 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `dataperpus`
--

CREATE TABLE `dataperpus` (
  `id` int(11) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `genre` varchar(30) NOT NULL,
  `penulis` varchar(30) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `lokasi` varchar(30) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `dataperpus`
--

INSERT INTO `dataperpus` (`id`, `judul`, `genre`, `penulis`, `penerbit`, `lokasi`, `stock`) VALUES
(16, 'Antara Kita dan Dia', 'Romance', 'Surya', 'Gramedia', 'LT2', 13),
(17, 'Sang Hujan', 'Romance', 'Surya', 'Gramedia', 'LT2', 13),
(18, 'The Night', 'Horror', 'Alex', 'Gagasmedia', 'LT 1', 12),
(19, 'You', 'Romance', 'Citra', 'Gramedia', 'LT 2', 123),
(20, 'Hikmah Puasa', 'Religi', 'Ahmad', 'Amanah ', 'LT 3', 10),
(35, 'The Earth', 'Nature', 'Surya Aji', 'Gramedia', 'LT1', 10),
(36, 'The Earth', 'Nature', 'Surya Aji', 'Gramedia', 'LT1', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dataperpus`
--
ALTER TABLE `dataperpus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dataperpus`
--
ALTER TABLE `dataperpus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Agu 2020 pada 04.25
-- Versi server: 10.4.13-MariaDB
-- Versi PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_dayafamily`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `nm_barang` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `satuan` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `harga_beli` int(9) NOT NULL,
  `harga_jual` int(9) NOT NULL,
  `stock` int(9) NOT NULL,
  `expired` date NOT NULL,
  `tgl_beli` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kd_barang`, `nm_barang`, `satuan`, `harga_beli`, `harga_jual`, `stock`, `expired`, `tgl_beli`) VALUES
('K0001', 'Pepsodent', 'Pcs', 6000, 8000, 200, '2022-07-28', '2020-07-28'),
('K0002', 'Ciptadent', 'Pcs', 3500, 5000, 200, '2022-07-28', '2020-07-28');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `id_user` int(11) NOT NULL,
  `username` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `level` varchar(10) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`id_user`, `username`, `password`, `level`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'pimpinan', 'pimpinan', 'pimpinan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kd_pel` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `nm_pel` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `alamat` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `no_hp` varchar(15) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pel`, `nm_pel`, `alamat`, `no_hp`) VALUES
('P001', 'Fauzy', 'Padang', '082288229856');

-- --------------------------------------------------------

--
-- Struktur dari tabel `suplier`
--

CREATE TABLE `suplier` (
  `kd_sup` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `nm_sup` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `alamat` varchar(100) COLLATE latin1_general_ci NOT NULL,
  `no_hp` varchar(15) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `suplier`
--

INSERT INTO `suplier` (`kd_sup`, `nm_sup`, `alamat`, `no_hp`) VALUES
('S001', 'fauzy', 'padang', '0822828222822');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksibeli`
--

CREATE TABLE `transaksibeli` (
  `no_fak_beli` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `tgl_beli` date NOT NULL,
  `kd_sup` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `kd_barang` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `jumlah` int(9) NOT NULL,
  `harga` int(9) NOT NULL,
  `total` int(9) NOT NULL,
  `stok` int(9) NOT NULL,
  `stok_sisa` int(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `transaksibeli`
--

INSERT INTO `transaksibeli` (`no_fak_beli`, `tgl_beli`, `kd_sup`, `kd_barang`, `jumlah`, `harga`, `total`, `stok`, `stok_sisa`) VALUES
('000001', '2020-07-03', 'S001', 'K0001', 10, 6000, 60000, 200, 210),
('000002', '2020-08-03', 'S001', 'K0002', 15, 3500, 52500, 200, 215);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksijual`
--

CREATE TABLE `transaksijual` (
  `no_fak_jual` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `tgl_jual` date NOT NULL,
  `kd_pel` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `kd_barang` varchar(7) COLLATE latin1_general_ci NOT NULL,
  `jumlah` int(9) NOT NULL,
  `harga` int(9) NOT NULL,
  `total` int(9) NOT NULL,
  `stok` int(9) NOT NULL,
  `stok_sisa` int(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data untuk tabel `transaksijual`
--

INSERT INTO `transaksijual` (`no_fak_jual`, `tgl_jual`, `kd_pel`, `kd_barang`, `jumlah`, `harga`, `total`, `stok`, `stok_sisa`) VALUES
('000001', '2020-08-03', 'P001', 'K0001', 10, 8000, 80000, 210, 200),
('000002', '2020-06-03', 'P001', 'K0002', 15, 5000, 75000, 215, 200);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kd_pel`);

--
-- Indeks untuk tabel `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`kd_sup`);

--
-- Indeks untuk tabel `transaksibeli`
--
ALTER TABLE `transaksibeli`
  ADD PRIMARY KEY (`no_fak_beli`);

--
-- Indeks untuk tabel `transaksijual`
--
ALTER TABLE `transaksijual`
  ADD PRIMARY KEY (`no_fak_jual`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

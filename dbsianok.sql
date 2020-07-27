-- phpMyAdmin SQL Dump
-- version 2.11.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 01, 2016 at 01:56 PM
-- Server version: 5.0.45
-- PHP Version: 5.2.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `dbsianok`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(10) collate latin1_general_ci NOT NULL,
  `nm_barang` varchar(15) collate latin1_general_ci NOT NULL,
  `satuan` varchar(15) collate latin1_general_ci NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY  (`kd_barang`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_barang`, `nm_barang`, `satuan`, `harga_beli`, `harga_jual`, `stock`) VALUES
('ST001', 'Sinta', 'Karung', 380000, 412000, 8),
('BT002', 'Bintang', 'Karung', 390000, 410000, 5),
('KG003', 'Kargil', 'Karung', 390000, 415000, 10),
('MB004', 'Mabar', 'Karung', 365000, 397000, 10),
('CF005', 'Comfeet', 'Karung', 388000, 410000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `costumer`
--

CREATE TABLE `costumer` (
  `kd_costumer` varchar(10) collate latin1_general_ci NOT NULL,
  `nm_costumer` varchar(20) collate latin1_general_ci NOT NULL,
  `alamat` varchar(40) collate latin1_general_ci NOT NULL,
  `tlp` varchar(15) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`kd_costumer`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `costumer`
--

INSERT INTO `costumer` (`kd_costumer`, `nm_costumer`, `alamat`, `tlp`) VALUES
('002', 'Pak Pilli', 'Baruah Kampuang Maninjau', '081363198546'),
('003', 'Pak Garujuah', 'Gasang Maninjau', '081374714076'),
('001', 'Nanda', 'Maninjau', '082284714778'),
('004', 'Radiman', 'Baruah Kampuang Maninjau', '081374803719');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) collate latin1_general_ci NOT NULL,
  `password` varchar(20) collate latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `no_faktur` varchar(10) collate latin1_general_ci NOT NULL,
  `tanggal` varchar(10) collate latin1_general_ci NOT NULL,
  `kd_suplier` varchar(5) collate latin1_general_ci NOT NULL,
  `nm_suplier` varchar(40) collate latin1_general_ci NOT NULL,
  `kd_barang` varchar(10) collate latin1_general_ci NOT NULL,
  `nm_barang` varchar(20) collate latin1_general_ci NOT NULL,
  `satuan` varchar(10) collate latin1_general_ci NOT NULL,
  `harga_beli` int(15) NOT NULL,
  `jumlah` int(5) NOT NULL,
  `stock` int(15) NOT NULL,
  `stok_baru` int(15) NOT NULL,
  `total_hrg` int(11) NOT NULL,
  `bayar` int(11) NOT NULL,
  `sisa` int(14) NOT NULL,
  PRIMARY KEY  (`no_faktur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`no_faktur`, `tanggal`, `kd_suplier`, `nm_suplier`, `kd_barang`, `nm_barang`, `satuan`, `harga_beli`, `jumlah`, `stock`, `stok_baru`, `total_hrg`, `bayar`, `sisa`) VALUES
('00001', '31-10-2016', '123', 'wert', '10001', 'ikua', 'Karuang', 1500, 6, 38, 44, 9000, 5999999, 5990999),
('', '', '', '', '', '', '', 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `no_faktur` varchar(10) collate latin1_general_ci NOT NULL,
  `tanggal` varchar(10) collate latin1_general_ci NOT NULL,
  `kd_costomer` varchar(5) collate latin1_general_ci NOT NULL,
  `nm_costumer` varchar(40) collate latin1_general_ci NOT NULL,
  `kd_barang` varchar(10) collate latin1_general_ci NOT NULL,
  `nm_barang` varchar(20) collate latin1_general_ci NOT NULL,
  `harga_jual` int(15) NOT NULL,
  `stock` int(11) NOT NULL,
  `jumlah` int(5) NOT NULL,
  `totalharga` int(15) NOT NULL,
  `bayar` int(15) NOT NULL,
  `sisa` int(14) NOT NULL,
  `stock_akhir` int(11) NOT NULL,
  PRIMARY KEY  (`no_faktur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`no_faktur`, `tanggal`, `kd_costomer`, `nm_costumer`, `kd_barang`, `nm_barang`, `harga_jual`, `stock`, `jumlah`, `totalharga`, `bayar`, `sisa`, `stock_akhir`) VALUES
('00001', '31-10-2016', '001', 'Nanda', 'ST001', 'Sinta', 412000, 10, 2, 824000, 850000, 26000, 8),
('00002', '31-10-2016', '002', 'Pak Pilli', 'BT002', 'Bintang', 410000, 10, 5, 2050000, 2100000, 50000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `kd_suplier` varchar(10) collate latin1_general_ci NOT NULL,
  `nm_suplier` varchar(20) collate latin1_general_ci NOT NULL,
  `alamat` varchar(40) collate latin1_general_ci NOT NULL,
  `telp` varchar(15) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`kd_suplier`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `suplier`
--

INSERT INTO `suplier` (`kd_suplier`, `nm_suplier`, `alamat`, `telp`) VALUES
('MB01', 'PT. Mabar Feed Indon', 'Medan Sumatera Utara', '082283105136'),
('ST02', 'PT. Sinta Prima Feed', 'Bogor, Indonesia', '082284714778'),
('KG03', 'PT. Kargill Indonesi', 'DKI Jakarta', '08126160277'),
('BT04', 'PT. Central Proteina', 'Batam', '082283109253'),
('CF05', 'PT. JAPFA COMFEED IN', 'DKI Jakarta', '082283590775');

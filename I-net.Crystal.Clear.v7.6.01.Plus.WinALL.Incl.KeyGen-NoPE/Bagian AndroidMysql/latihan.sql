/*
SQLyog Enterprise - MySQL GUI v8.2 RC2
MySQL - 5.5.8 : Database - latihan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`latihan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `latihan`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `city_id` int(11) NOT NULL,
  `city_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `city` */

insert  into `city`(`city_id`,`city_name`) values (1,'Angkasa'),(2,'Amerika');

/*Table structure for table `people` */

DROP TABLE IF EXISTS `people`;

CREATE TABLE `people` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(11) NOT NULL,
  `birthyear` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `people` */

insert  into `people`(`id`,`name`,`sex`,`birthyear`) values (1,'Safaat H',1,1970),(2,'Santoso',2,2010),(3,'Nazruddin Safaat H',1,1996),(4,'Budi Santoso',2,1982),(0,'meizano',1,1980);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `repassword` varchar(20) NOT NULL,
  `nama_lengkap` varchar(40) NOT NULL,
  `jekel` varchar(10) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `nomor_tlp` varchar(10) NOT NULL,
  `nomor_hp` varchar(12) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`repassword`,`nama_lengkap`,`jekel`,`alamat`,`nomor_tlp`,`nomor_hp`) values ('Farah','farah','Medan123','Farah Siregar','Perempuan','Bandung ','0222674666','081268680786'),('ronny.hermansyah','1234567890123456','1234567890123456','Ronny hermansyah H','Pria','Bandung','082773473 ','08765767534 ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

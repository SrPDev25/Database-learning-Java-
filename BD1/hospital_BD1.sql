CREATE DATABASE  IF NOT EXISTS `prog_primera_base` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `prog_primera_base`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: prog_primera_base
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `enfermomedicación`
--

DROP TABLE IF EXISTS `enfermomedicación`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfermomedicación` (
  `NumeroSegSocial` varchar(12) NOT NULL,
  `CodigoMedicacion` varchar(5) NOT NULL,
  PRIMARY KEY (`NumeroSegSocial`,`CodigoMedicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermomedicación`
--

LOCK TABLES `enfermomedicación` WRITE;
/*!40000 ALTER TABLE `enfermomedicación` DISABLE KEYS */;
INSERT INTO `enfermomedicación` VALUES ('1','1'),('1','2'),('2','1');
/*!40000 ALTER TABLE `enfermomedicación` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicaciones`
--

DROP TABLE IF EXISTS `medicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicaciones` (
  `CodigoMedicacion` varchar(5) NOT NULL,
  `Denominacion` varchar(40) DEFAULT NULL,
  `Indicaciones` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`CodigoMedicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicaciones`
--

LOCK TABLES `medicaciones` WRITE;
/*!40000 ALTER TABLE `medicaciones` DISABLE KEYS */;
INSERT INTO `medicaciones` VALUES ('1','Dalsy','una vez'),('2','MedJ','dos veces');
/*!40000 ALTER TABLE `medicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblusuarios`
--

DROP TABLE IF EXISTS `tblusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblusuarios` (
  `login` varchar(48) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(1) NOT NULL,
  PRIMARY KEY (`Codigo`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblusuarios`
--

LOCK TABLES `tblusuarios` WRITE;
/*!40000 ALTER TABLE `tblusuarios` DISABLE KEYS */;
INSERT INTO `tblusuarios` VALUES ('0','0','Juan',1,'f'),('admin','admin','admin',2,'f');
/*!40000 ALTER TABLE `tblusuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tvlenfermos`
--

DROP TABLE IF EXISTS `tvlenfermos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tvlenfermos` (
  `numeroSeguridadSocial` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numeroSeguridadSocial`),
  UNIQUE KEY `numeroSeguridadSocial_UNIQUE` (`numeroSeguridadSocial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tvlenfermos`
--

LOCK TABLES `tvlenfermos` WRITE;
/*!40000 ALTER TABLE `tvlenfermos` DISABLE KEYS */;
INSERT INTO `tvlenfermos` VALUES (1,'ElPepe'),(2,'Juan'),(3,'Alvar'),(4,'MCe');
/*!40000 ALTER TABLE `tvlenfermos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24 13:09:45

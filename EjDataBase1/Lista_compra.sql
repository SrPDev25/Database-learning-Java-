CREATE DATABASE  IF NOT EXISTS `dam_programacion_listacompras` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dam_programacion_listacompras`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dam_programacion_listacompras
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
-- Table structure for table `tblcategorias`
--

DROP TABLE IF EXISTS `tblcategorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblcategorias` (
  `codigo_categoria` int(11) NOT NULL,
  `denominacion` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategorias`
--

LOCK TABLES `tblcategorias` WRITE;
/*!40000 ALTER TABLE `tblcategorias` DISABLE KEYS */;
INSERT INTO `tblcategorias` VALUES (1,'perfumeria'),(3,'Esta rico'),(11,'perfumeria'),(24,'juan');
/*!40000 ALTER TABLE `tblcategorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllistas`
--

DROP TABLE IF EXISTS `tbllistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbllistas` (
  `codigo_lista` int(11) NOT NULL,
  `denominacion` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_lista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllistas`
--

LOCK TABLES `tbllistas` WRITE;
/*!40000 ALTER TABLE `tbllistas` DISABLE KEYS */;
INSERT INTO `tbllistas` VALUES (3,'ListaPrueba'),(1111,'verano');
/*!40000 ALTER TABLE `tbllistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllistas_productos`
--

DROP TABLE IF EXISTS `tbllistas_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbllistas_productos` (
  `codigo_lista` int(11) NOT NULL,
  `codigo_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`codigo_lista`,`codigo_producto`),
  KEY `lista_idx` (`codigo_lista`),
  KEY `producto_idx` (`codigo_producto`),
  CONSTRAINT `lista` FOREIGN KEY (`codigo_lista`) REFERENCES `tbllistas` (`codigo_lista`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `producto` FOREIGN KEY (`codigo_producto`) REFERENCES `tblproductos` (`codigo_producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllistas_productos`
--

LOCK TABLES `tbllistas_productos` WRITE;
/*!40000 ALTER TABLE `tbllistas_productos` DISABLE KEYS */;
INSERT INTO `tbllistas_productos` VALUES (3,3,1),(1111,3,24);
/*!40000 ALTER TABLE `tbllistas_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproductos`
--

DROP TABLE IF EXISTS `tblproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblproductos` (
  `codigo_producto` int(11) NOT NULL,
  `denominacion` varchar(20) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  PRIMARY KEY (`codigo_producto`),
  KEY `categoria_idx` (`codigo_categoria`),
  CONSTRAINT `categoria` FOREIGN KEY (`codigo_categoria`) REFERENCES `tblcategorias` (`codigo_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproductos`
--

LOCK TABLES `tblproductos` WRITE;
/*!40000 ALTER TABLE `tblproductos` DISABLE KEYS */;
INSERT INTO `tblproductos` VALUES (3,'asdfsad',3),(5,'fgdhfgh',3),(22,'colonia',1),(111,'colonia',11);
/*!40000 ALTER TABLE `tblproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14 13:58:26

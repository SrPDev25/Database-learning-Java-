CREATE DATABASE  IF NOT EXISTS `dam_programacion_biblioteca` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dam_programacion_biblioteca`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: dam_programacion_biblioteca
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
-- Table structure for table `tbl_ejemplares`
--

DROP TABLE IF EXISTS `tbl_ejemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ejemplares` (
  `codigo_ejemplar` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(20) NOT NULL,
  `situacion` varchar(45) NOT NULL DEFAULT 'Disponible',
  `fecha_devolucion` date DEFAULT NULL,
  `codigo_usuario` varchar(9) DEFAULT NULL,
  `renovado` varchar(2) NOT NULL DEFAULT 'no',
  PRIMARY KEY (`codigo_ejemplar`),
  KEY `isbn_idx` (`isbn`),
  KEY `usuario_idx` (`codigo_usuario`),
  CONSTRAINT `isbn` FOREIGN KEY (`isbn`) REFERENCES `tbl_libros` (`isbn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `tbl_usuarios` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_ejemplares`
--

LOCK TABLES `tbl_ejemplares` WRITE;
/*!40000 ALTER TABLE `tbl_ejemplares` DISABLE KEYS */;
INSERT INTO `tbl_ejemplares` VALUES (1,'234564','Prestado','2022-06-29','0','no'),(2,'234564','Prestado','2022-06-29','1','no'),(3,'234564','Disponible',NULL,NULL,'no'),(4,'234564','Disponible',NULL,NULL,'no'),(5,'745123','Disponible',NULL,NULL,'no'),(6,'745123','Disponible',NULL,NULL,'no'),(7,'745123','Disponible',NULL,NULL,'no'),(8,'784223','Prestado','2022-06-29','1','no'),(9,'784223','Disponible',NULL,NULL,'no'),(10,'784223','Disponible',NULL,NULL,'no'),(11,'784223','Disponible',NULL,NULL,'no'),(12,'784223','Disponible',NULL,NULL,'no'),(13,'784223','Disponible',NULL,NULL,'no');
/*!40000 ALTER TABLE `tbl_ejemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_libros`
--

DROP TABLE IF EXISTS `tbl_libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_libros` (
  `isbn` varchar(20) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_libros`
--

LOCK TABLES `tbl_libros` WRITE;
/*!40000 ALTER TABLE `tbl_libros` DISABLE KEYS */;
INSERT INTO `tbl_libros` VALUES ('102564','El capital'),('234564','Harry Potter y los secretos ibericos'),('745123','Harry Potter y las reliquias de la abuela'),('784223','Harry Potter y la orden de alejamiento');
/*!40000 ALTER TABLE `tbl_libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuarios`
--

DROP TABLE IF EXISTS `tbl_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuarios` (
  `cod_usuario` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `login` varchar(40) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `tipo_usuario` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuarios`
--

LOCK TABLES `tbl_usuarios` WRITE;
/*!40000 ALTER TABLE `tbl_usuarios` DISABLE KEYS */;
INSERT INTO `tbl_usuarios` VALUES ('0','admin','0','cfcd208495d565ef66e7dff9f98764da','a'),('1','socio_pepe','1','c4ca4238a0b923820dcc509a6f75849b','s'),('2','socio_CJ','cj','c4ca4238a0b923820dcc509a6f75849b','s');
/*!40000 ALTER TABLE `tbl_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14 13:49:58

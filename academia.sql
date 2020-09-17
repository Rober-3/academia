-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: academia
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1

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
-- Current Database: `academia`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `academia` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `academia`;

--
-- Table structure for table `alumnosCurso`
--

DROP TABLE IF EXISTS `alumnosCurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnosCurso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_alumno` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario_FK` (`id_alumno`),
  KEY `curso_FK` (`id_curso`),
  CONSTRAINT `curso_FK` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id`),
  CONSTRAINT `usuario_FK` FOREIGN KEY (`id_alumno`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnosCurso`
--

LOCK TABLES `alumnosCurso` WRITE;
/*!40000 ALTER TABLE `alumnosCurso` DISABLE KEYS */;
INSERT INTO `alumnosCurso` VALUES (1,4,1),(2,4,2),(3,5,1),(4,5,3),(5,6,2),(6,6,3),(7,7,1),(8,7,3),(9,5,8),(10,4,8),(11,4,8);
/*!40000 ALTER TABLE `alumnosCurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(100) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `horas` int(11) NOT NULL,
  `id_profesor` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UN` (`curso`),
  UNIQUE KEY `codigo_UN` (`codigo`),
  KEY `cursos_FK` (`id_profesor`),
  CONSTRAINT `cursos_FK` FOREIGN KEY (`id_profesor`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Microsoft Office 2016','I001',50,1),(2,'Experto en Desarrollo de Aplicaciones WEB y Bases de Datos','I002',630,2),(3,'Desarrollo Avanzado con JAVA/JEE','I003',510,3),(8,'Bases de datos','I004',500,1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `rol` int(11) NOT NULL COMMENT '1: alumno \n2: profesor',
  `contrasena` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuarios` (`nombre`,`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Alain','Moles',2,'202cb962ac59075b964b07152d234b70'),(2,'Ander','Uraga',2,'202cb962ac59075b964b07152d234b70'),(3,'Pepito','Piscinas',2,'202cb962ac59075b964b07152d234b70'),(4,'Asier','Mintegui',1,'202cb962ac59075b964b07152d234b70'),(5,'Beatriz','Martínez',1,'202cb962ac59075b964b07152d234b70'),(6,'Elier','Otero',1,'202cb962ac59075b964b07152d234b70'),(7,'Lander','Bilbao',1,'202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-18  0:23:42

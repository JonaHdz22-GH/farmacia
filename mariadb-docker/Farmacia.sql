CREATE DATABASE  IF NOT EXISTS `farmacia` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `farmacia`;
-- MySQL dump 10.16  Distrib 10.1.38-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	10.1.38-MariaDB-0ubuntu0.18.04.2

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
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacto` (
  `id_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `contacto` varchar(45) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_contacto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT INTO `contacto` VALUES (1,'Teléfono fijo','','Medio de contacto usado en el hogar, oficina etc de forma local.'),(2,'Celular','','Medio de contacto usado de forma personal.'),(3,'Correo electronico','','Medio de contacto de correos de forma personal.'),(4,'Mensajes de texto ','','Medio de contacto de celulares, para contactar de forma breve.'),(5,'Chat','','Medio de contacto de forma interactuada directamente.'),(6,'Correo 2','','Medio de contacto por cartas enviadas a la direcciòn local del usuario.');
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descuento` (
  `id_descuento` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_descuento` int(11) NOT NULL,
  PRIMARY KEY (`id_descuento`),
  KEY `fk_descuento_tipo_descuento1_idx` (`id_tipo_descuento`),
  CONSTRAINT `fk_descuento_tipo_descuento1` FOREIGN KEY (`id_tipo_descuento`) REFERENCES `tipo_descuento` (`id_tipo_descuento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (1,1),(2,1),(3,2),(4,2),(5,3),(6,3);
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle` (
  `id_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `id_detalle_producto` int(11) NOT NULL,
  `formula` varchar(45) DEFAULT NULL,
  `nombre_laboratorio` varchar(45) DEFAULT NULL,
  `indicaciones` varchar(300) DEFAULT NULL,
  `precauciones` varchar(300) DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_detalle`),
  KEY `fk_detalle_detalle_producto1_idx` (`id_detalle_producto`),
  CONSTRAINT `fk_detalle_detalle_producto1` FOREIGN KEY (`id_detalle_producto`) REFERENCES `detalle_producto` (`id_detalle_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
INSERT INTO `detalle` VALUES (1,1,'z-10-b20º','Laboratorio Lopez','Usar en zona afectada','No usar en lugares irritados, no consumir, no aplicar en los ojos','Ninguna'),(2,2,'P-10','Sontoma-LX','',NULL,NULL),(3,3,'K-10','Familia AA',NULL,NULL,NULL),(4,4,'Nor-ME','ABALON PHARMA, S.L.',NULL,NULL,NULL),(5,5,'OA-15001','ABELLO LINDE',NULL,NULL,NULL);
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_producto`
--

DROP TABLE IF EXISTS `detalle_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_producto` (
  `id_detalle_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_producto`),
  KEY `fk_detalle_producto_producto1_idx` (`id_producto`),
  CONSTRAINT `fk_detalle_producto_producto1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_producto`
--

LOCK TABLES `detalle_producto` WRITE;
/*!40000 ALTER TABLE `detalle_producto` DISABLE KEYS */;
INSERT INTO `detalle_producto` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `detalle_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `id_detalle_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `id_descuento` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `valor_venta` double DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_detalle_venta`),
  KEY `fk_detalle_venta_factura1_idx` (`id_factura`),
  KEY `fk_detalle_venta_descuento1_idx` (`id_descuento`),
  KEY `fk_detalle_venta_producto1_idx` (`id_producto`),
  CONSTRAINT `fk_detalle_venta_descuento1` FOREIGN KEY (`id_descuento`) REFERENCES `descuento` (`id_descuento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_factura1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_producto1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (6,1,1,1,5,15.07,'Ninguna'),(7,2,1,1,6,12.06,'Ninguna'),(8,3,1,1,3,6.05,'Ninguna'),(9,3,3,2,6,22.07,'Ninguna'),(10,4,3,2,4,26.07,'Ninguna'),(11,5,3,2,4,12.44,'Ninguna'),(12,6,5,3,3,15.09,'Ninguna'),(13,7,5,3,3,12.08,'Ninguna');
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_pago` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_factura`),
  KEY `fk_factura_usuario1_idx` (`id_usuario`),
  KEY `fk_factura_pago1_idx` (`id_pago`),
  CONSTRAINT `fk_factura_pago1` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,1,1,'2019-02-03','Ninguna'),(2,2,3,'2019-03-04','Ninguna'),(3,3,5,'2018-05-05','Ninguna'),(4,4,1,'2018-06-04','Ninguna'),(5,5,3,'2018-07-10','Ninguna'),(6,6,5,'2018-10-10','Ninguna');
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pago`
--

DROP TABLE IF EXISTS `forma_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pago` (
  `id_forma_pago` int(11) NOT NULL AUTO_INCREMENT,
  `forma_pago` varchar(45) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_forma_pago`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pago`
--

LOCK TABLES `forma_pago` WRITE;
/*!40000 ALTER TABLE `forma_pago` DISABLE KEYS */;
INSERT INTO `forma_pago` VALUES (1,'Efectivo','','Se paga de forma monetaria'),(2,'Tarjeta Credito','','Se paga a la cuenta de la farmacia'),(3,'Tarjeta Afiliado','','Se descuenta de los ahorros de la tarjeta afiliado');
/*!40000 ALTER TABLE `forma_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventario` (
  `id_inventario` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_venta` double DEFAULT NULL,
  `fecha_fabricacion` date DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_inventario`),
  KEY `fk_inventario_sucursal1_idx` (`id_sucursal`),
  KEY `fk_inventario_producto1_idx` (`id_producto`),
  CONSTRAINT `fk_inventario_producto1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inventario_sucursal1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
INSERT INTO `inventario` VALUES (1,6,1,80,55.25,'2018-11-05','2021-07-15','','Venta solo con autorizaciòn'),(2,1,1,3500,0.12,'2018-09-16','2025-12-12','','Ninguna'),(3,2,3,1500,3.5,'2014-04-03','2026-05-05','','Ninguna'),(4,3,1,600,1.25,'2017-03-04','2029-11-11','','Ninguna');
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medio_contacto`
--

DROP TABLE IF EXISTS `medio_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medio_contacto` (
  `id_medio_contacto` int(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor` int(11) NOT NULL,
  `id_contacto` int(11) NOT NULL,
  PRIMARY KEY (`id_medio_contacto`),
  KEY `fk_medio_contacto_proveedor1_idx` (`id_proveedor`),
  KEY `fk_medio_contacto_contacto1_idx` (`id_contacto`),
  CONSTRAINT `fk_medio_contacto_contacto1` FOREIGN KEY (`id_contacto`) REFERENCES `contacto` (`id_contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medio_contacto_proveedor1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medio_contacto`
--

LOCK TABLES `medio_contacto` WRITE;
/*!40000 ALTER TABLE `medio_contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `medio_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `id_pago` int(11) NOT NULL AUTO_INCREMENT,
  `id_forma_pago` int(11) NOT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `fk_pago_forma_pago1_idx` (`id_forma_pago`),
  CONSTRAINT `fk_pago_forma_pago1` FOREIGN KEY (`id_forma_pago`) REFERENCES `forma_pago` (`id_forma_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,1),(2,1),(3,2),(4,2),(5,3),(6,3);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presentacion_producto`
--

DROP TABLE IF EXISTS `presentacion_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `presentacion_producto` (
  `id_presentacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_presentacion` int(11) NOT NULL,
  `id_detalle` int(11) NOT NULL,
  PRIMARY KEY (`id_presentacion`),
  KEY `fk_presentacion_producto_tipo_presentacion1_idx` (`id_tipo_presentacion`),
  KEY `fk_presentacion_producto_detalle1_idx` (`id_detalle`),
  CONSTRAINT `fk_presentacion_producto_detalle1` FOREIGN KEY (`id_detalle`) REFERENCES `detalle` (`id_detalle`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_presentacion_producto_tipo_presentacion1` FOREIGN KEY (`id_tipo_presentacion`) REFERENCES `tipo_presentacion` (`id_tipo_presentacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presentacion_producto`
--

LOCK TABLES `presentacion_producto` WRITE;
/*!40000 ALTER TABLE `presentacion_producto` DISABLE KEYS */;
INSERT INTO `presentacion_producto` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1);
/*!40000 ALTER TABLE `presentacion_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor_producto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_producto`),
  KEY `fk_producto_proveedor_producto1_idx` (`id_proveedor_producto`),
  CONSTRAINT `fk_producto_proveedor_producto1` FOREIGN KEY (`id_proveedor_producto`) REFERENCES `proveedor_producto` (`id_proveedor_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,1,'Acetaminofen unidad','Unidad'),(2,1,'Acetaminofen caja','Caja 12 unidades por caja'),(3,1,'Acetaminofen tira','Tira de 6 unidades'),(4,2,'Pomada dolor muscular frasco','Frasco 12g'),(5,2,'Pomada dolor muscular tubo','Tubo 6g'),(6,5,'Sidobudina','Inyecciones 3.5ml'),(7,5,'Sirofos-Migraña','Caja de 6 unidades-recetada');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` varchar(45) NOT NULL,
  `nombre_empresa` varchar(45) NOT NULL,
  `direccion_empresa` varchar(45) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Luz Contreras','Roche','Santa Ana ','','Ninguna'),(2,'Andrea Flores','Mercury ','Santa Ana','','Ninguna'),(3,'Mercedes Carrera','Sinfonte','Chalchuapa','','Ninguna'),(4,'Maria Jose','Vengala','Sonsonate','','Ninguna'),(5,'Carlos Martinez','Dilecsa','Sonsonate','','Ninguna'),(6,'Lizbeth Tat','Morches-AL','San Salvador','','Productos solo con recetas');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_producto`
--

DROP TABLE IF EXISTS `proveedor_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor_producto` (
  `id_proveedor_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_proveedor` int(11) NOT NULL,
  `precio_compra` double NOT NULL,
  `descuento_compra` double NOT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_proveedor_producto`),
  KEY `fk_proveedor_producto_proveedor1_idx` (`id_proveedor`),
  CONSTRAINT `fk_proveedor_producto_proveedor1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_producto`
--

LOCK TABLES `proveedor_producto` WRITE;
/*!40000 ALTER TABLE `proveedor_producto` DISABLE KEYS */;
INSERT INTO `proveedor_producto` VALUES (1,1,1600.21,44.21,'Proveedor de frascos '),(2,2,3500,300,'Proveedor de pastillas'),(3,4,4500.24,200.45,'Proveedor de pastillas por unidad y pomadas'),(4,3,1200.5,150.6,'Proveedor de ampollas bebibles'),(5,6,10000,1200,'Proveedor de todo tipo de producto recetado');
/*!40000 ALTER TABLE `proveedor_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_sucursal` varchar(45) NOT NULL,
  `direccion_sucursal` varchar(45) NOT NULL,
  `telefono_sucursal` varchar(45) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'La bendiciòn','Santa Ana','2456-7890','Principal farmacia de la ciudad de Santa Ana'),(2,'La esperanza','Sonsonate','2231-4541','Pequeña farmacia '),(3,'Santa Monica','Ahuachapan ','2980-5789','Farmacia');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_descuento`
--

DROP TABLE IF EXISTS `tipo_descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_descuento` (
  `id_tipo_descuento` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_descuento` varchar(45) NOT NULL,
  `descuento` double DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_tipo_descuento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_descuento`
--

LOCK TABLES `tipo_descuento` WRITE;
/*!40000 ALTER TABLE `tipo_descuento` DISABLE KEYS */;
INSERT INTO `tipo_descuento` VALUES (1,'Dia festivo',5,'Se dara un 5% de descuento en cada producto'),(2,'Tarjeta afiliada',8,'Por afiliacion con tarjetase dara 8% por producto'),(3,'Proximo vencerce',6,'Producto a 2 años de caducar 6%');
/*!40000 ALTER TABLE `tipo_descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_presentacion`
--

DROP TABLE IF EXISTS `tipo_presentacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_presentacion` (
  `id_tipo_presentacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `descripcion` text,
  PRIMARY KEY (`id_tipo_presentacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_presentacion`
--

LOCK TABLES `tipo_presentacion` WRITE;
/*!40000 ALTER TABLE `tipo_presentacion` DISABLE KEYS */;
INSERT INTO `tipo_presentacion` VALUES (1,'Pastillas unidad','','Sobres individuales que contienen una pastilla'),(2,'Caja de pastillas','','Continen 12 unidades de pastillas'),(3,'Bebible','','Bote de 75ml'),(4,'Inyectable','','Contenido liquido para uso con jeringas'),(5,'Pomada','','Bote de pomada de 25g ');
/*!40000 ALTER TABLE `tipo_presentacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `estado` bit(1) DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Laura','Martinez','','Ninguna'),(2,'Berenice','Carballo','','Ninguna'),(3,'Tatiana','Alvarenga','','Ninguna'),(4,'Jose','Moratay','','Ninguna'),(5,'Angel','Ruiz','','Ninguna'),(6,'Karla','Palma','','Ninguna'),(7,'Beatriz','Sermeño','','Ninguna'),(8,'Monica','Moran','','Ninguna'),(9,'Leticia','Nuñez','','Ninguna'),(10,'Lizbeth','Tat','','Ninguna'),(11,'Laura 22','Martinez','','Ninguna'),(12,'Laura 333','Martinez','','Ninguna'),(13,'Laura 000','Martinez','','Ninguna');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-04 11:14:37

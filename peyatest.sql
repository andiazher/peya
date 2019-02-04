# ************************************************************
# Sequel Pro SQL dump
# Versión 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.24)
# Base de datos: peyatest
# Tiempo de Generación: 2019-02-04 20:50:18 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla calificacion
# ------------------------------------------------------------

DROP TABLE IF EXISTS `calificacion`;

CREATE TABLE `calificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `tienda` int(11) NOT NULL,
  `compra` int(11) NOT NULL,
  `comentario` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Buen servicio',
  `calificacion` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;

INSERT INTO `calificacion` (`id`, `usuario`, `tienda`, `compra`, `comentario`, `calificacion`, `fecha`, `eliminado`)
VALUES
	(1,12,7072,882,'Buena atencion',5,'2019-02-04 08:19:29',0),
	(2,12,7072,112,'Buen servicio',4,'2019-02-04 06:15:13',0),
	(12,12,7072,122,'Buen servicio',5,'2019-02-04 00:00:00',0),
	(13,12,7072,122,'Buen servicio',5,'2019-02-02 00:00:00',1),
	(14,12,7072,122,'Buen servicio',5,'2019-02-01 00:00:00',1),
	(15,12,7072,122,'Buen servicio',5,'2019-02-05 00:00:00',0),
	(16,12,7072,122,'Buen servicio',3,'2019-02-04 00:00:00',0);

/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;


# Volcado de tabla tienda_calificacion
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tienda_calificacion`;

CREATE TABLE `tienda_calificacion` (
  `tienda` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `calificacion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tienda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

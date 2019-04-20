DROP DATABASE IF EXISTS hibernate;
CREATE DATABASE hibernate;
USE hibernate;
DROP TABLE IF EXISTS `hibernate`.`autos`;
CREATE TABLE  `hibernate`.`autos` (
  `au_id` int(10) unsigned NOT NULL auto_increment,
  `au_marca` varchar(255) NOT NULL default '',
  `au_modelo` varchar(255) NOT NULL default '',
  `au_fecha_venta` date NOT NULL default '0000-00-00',
  `au_precio` float NOT NULL default '0',
  `au_concesionario` int NOT NULL default '0',
  PRIMARY KEY  (`au_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS concesionarios;
CREATE TABLE `concesionarios` (
  `co_id` int(10) unsigned NOT NULL auto_increment,
  `co_nombre` varchar(255) NOT NULL default '',
  `co_direccion` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`co_id`)
) ENGINE=MyISAM;

SELECT * FROM autos;
SELECT * FROM concesionarios;

INSERT INTO `autos` (`au_id`,`au_marca`,`au_modelo`,`au_fecha_venta`,`au_precio`) VALUES 
 (1,'chevrolet','2000','2005-05-05',18000),
 (2,'chevrolet','1999','2005-01-01',15000),
 (3,'fiat','2000','2005-01-06',14000),
 (4,'peugeot','1998','2004-01-09',12000),
 (5,'peugeot','1997','2003-05-06',9500),
 (6,'chevrolet','1998','2006-01-01',8900),
 (7,'ford','2002','2002-05-06',13500),
 (8,'ford','2003','2002-09-09',16000);
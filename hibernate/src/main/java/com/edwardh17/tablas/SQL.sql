DROP DATABASE IF EXISTS hibernate;
CREATE DATABASE hibernate;
USE hibernate;
DROP TABLE IF EXISTS autos;
CREATE TABLE `autos` (
  `au_id` int(10) unsigned NOT NULL auto_increment,
  `au_marca` varchar(255) NOT NULL default '',
  `au_modelo` varchar(255) NOT NULL default '',
  `au_concesionario` int(10) NULL,
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


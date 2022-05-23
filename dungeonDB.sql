-- Adminer 4.8.1 MySQL 5.5.5-10.5.15-MariaDB-0ubuntu0.21.10.1 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `game.Board`;
CREATE TABLE `Board` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `playerPosition` int(11) DEFAULT NULL,
                         `cells_id` int(11) DEFAULT NULL,
                         `Hero_id` int(10) unsigned NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `fk_Board_Hero1_idx` (`Hero_id`),
                         CONSTRAINT `fk_Board_Hero1` FOREIGN KEY (`Hero_id`) REFERENCES `Hero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `board_has_cells`;
CREATE TABLE `board_has_cells` (
                                   `Board_id` int(11) NOT NULL,
                                   `Cell_id` int(11) NOT NULL,
                                   PRIMARY KEY (`Board_id`,`Cell_id`),
                                   KEY `fk_board_has_cells_Board1_idx` (`Board_id`),
                                   KEY `fk_board_has_cells_Cell1_idx` (`Cell_id`),
                                   CONSTRAINT `fk_board_has_cells_Board1` FOREIGN KEY (`Board_id`) REFERENCES `Board` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                   CONSTRAINT `fk_board_has_cells_Cell1` FOREIGN KEY (`Cell_id`) REFERENCES `Cell` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `game.Cell`;
CREATE TABLE `Cell` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `position` int(11) DEFAULT NULL,
                        `event_id` int(11) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `cell_has_event`;
CREATE TABLE `cell_has_event` (
                                  `Cell_id` int(11) NOT NULL,
                                  `Event_id` int(11) NOT NULL,
                                  KEY `fk_cell_has_event_Cell1_idx` (`Cell_id`),
                                  KEY `fk_cell_has_event_Event1_idx` (`Event_id`),
                                  CONSTRAINT `fk_cell_has_event_Cell1` FOREIGN KEY (`Cell_id`) REFERENCES `Cell` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                  CONSTRAINT `fk_cell_has_event_Event1` FOREIGN KEY (`Event_id`) REFERENCES `Event` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `DefensiveGear`;
CREATE TABLE `DefensiveGear` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(45) NOT NULL,
                                 `stat` int(11) NOT NULL,
                                 `authorizedHandler_id` int(11) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `authorizedHandler_id` (`authorizedHandler_id`),
                                 CONSTRAINT `DefensiveGear_ibfk_1` FOREIGN KEY (`authorizedHandler_id`) REFERENCES `PlayersType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DefensiveGear` (`id`, `name`, `stat`, `authorizedHandler_id`) VALUES
                                                                               (1,	'Philter',	5,	2),
                                                                               (2,	'Shield',	5,	1);

DROP TABLE IF EXISTS `Enemy`;
CREATE TABLE `Enemy` (
                         `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `type` varchar(45) DEFAULT NULL,
                         `image` varchar(100) DEFAULT NULL,
                         `lifepoints` int(11) NOT NULL,
                         `attack` int(10) unsigned NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Event`;
CREATE TABLE `Event` (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `type` varchar(45) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Gear`;
CREATE TABLE `Gear` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) NOT NULL,
                        `stat` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Hero`;
CREATE TABLE `Hero` (
                        `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                        `name` varchar(45) NOT NULL,
                        `image` varchar(200) DEFAULT NULL,
                        `lifepoints` int(11) NOT NULL,
                        `attack` int(10) unsigned NOT NULL,
                        `maxLifePoints` int(10) unsigned NOT NULL,
                        `maxAttack` int(10) unsigned NOT NULL,
                        `PlayersType_id` int(11) NOT NULL,
                        `offensiveGear_id` int(10) unsigned DEFAULT NULL,
                        `defensiveGear_id` int(10) unsigned DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `PlayersType_id` (`PlayersType_id`),
                        CONSTRAINT `Hero_ibfk_1` FOREIGN KEY (`PlayersType_id`) REFERENCES `PlayersType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `Hero` (`id`, `name`, `image`, `lifepoints`, `attack`, `maxLifePoints`, `maxAttack`, `PlayersType_id`, `offensiveGear_id`, `defensiveGear_id`) VALUES
                                                                                                                                                               (1,	'Diane',	'https://st.depositphotos.com/1001951/1865/i/450/depositphotos_18654711-stock-photo-medieval-knight.jpg',	5,	5,	10,	10,	1,	NULL,	NULL),
                                                                                                                                                               (2,	'Radagast',	'https://static.wikia.nocookie.net/seigneur-des-anneaux/images/6/60/Radagast_le_Brun.jpg/revision/latest/scale-to-width-down/624?cb=20210409175243&path-prefix=fr',	3,	8,	6,	15,	2,	NULL,	NULL),
                                                                                                                                                               (3,	'Jean-Claude',	'https://www.booska-p.com/wp-content/uploads/2022/02/jean-claude-van-damme-annonce-sa-retraite-je-veux-me-detendre-news-visu.jpg',	5,	5,	10,	10,	1,	2,	NULL),
                                                                                                                                                               (4,	'Garcimore',	'http://t2.gstatic.com/licensed-image?q=tbn:ANd9GcTqd-AAW_aP26qY0_vTbtSW2KcCVxNDoVsn5q266V4M6NQzHzTE2H9H7xcJ0Fw2',	3,	8,	6,	15,	2,	1,	NULL);

DROP TABLE IF EXISTS `hero_has_gear`;
CREATE TABLE `hero_has_gear` (
                                 `Gear_id` int(10) unsigned NOT NULL,
                                 `Hero_id` int(10) unsigned NOT NULL,
                                 KEY `fk_hero_has_gear_Gear1_idx` (`Gear_id`),
                                 KEY `fk_hero_has_gear_Hero1_idx` (`Hero_id`),
                                 CONSTRAINT `fk_hero_has_gear_Gear1` FOREIGN KEY (`Gear_id`) REFERENCES `Gear` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                                 CONSTRAINT `fk_hero_has_gear_Hero1` FOREIGN KEY (`Hero_id`) REFERENCES `Hero` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `OffensiveGear`;
CREATE TABLE `OffensiveGear` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `name` varchar(45) NOT NULL,
                                 `authorizedHandler_id` int(11) NOT NULL,
                                 `stat` varchar(45) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `authorizedHandler_id` (`authorizedHandler_id`),
                                 CONSTRAINT `OffensiveGear_ibfk_1` FOREIGN KEY (`authorizedHandler_id`) REFERENCES `PlayersType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `OffensiveGear` (`id`, `name`, `authorizedHandler_id`, `stat`) VALUES
                                                                               (1,	'Fireball',	2,	'7'),
                                                                               (2,	'Sword',	1,	'5'),
                                                                               (3,	'Hammer',	1,	'3'),
                                                                               (4,	'Bolt',	2,	'2');

DROP TABLE IF EXISTS `PlayersType`;
CREATE TABLE `PlayersType` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `name` varchar(45) NOT NULL,
                               `lifePoints` int(11) NOT NULL,
                               `maxLifePoints` int(11) NOT NULL,
                               `attack` int(11) NOT NULL,
                               `maxAttack` int(11) NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `PlayersType` (`id`, `name`, `lifePoints`, `maxLifePoints`, `attack`, `maxAttack`) VALUES
                                                                                                   (1,	'Warrior',	5,	10,	5,	10),
                                                                                                   (2,	'Wizard',	3,	6,	8,	15);


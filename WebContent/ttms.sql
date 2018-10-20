DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `F_director` varchar(20) NOT NULL,
  `F_type` varchar(16) NOT NULL,
  `F_region` varchar(20) NOT NULL,
  `F_language` varchar(20) NOT NULL,
  `F_time` varchar(20) NOT NULL,
  `F_performer` varchar(40) NOT NULL,
  `F_name` varchar(20) NOT NULL,
  `F_url` mediumblob NOT NULL,
  PRIMARY KEY (`F_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(11) NOT NULL,
  `userpassword` varchar(11) NOT NULL,
  `telephone` varchar(13) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `P_name` varchar(20) NOT NULL,
  `P_id` int(11) NOT NULL,
  `P_start` varchar(10) NOT NULL,
  `P_end` varchar(10) NOT NULL,
  `P_time` varchar(10) NOT NULL,
  KEY `plan_ibfk_1` (`P_name`),
  KEY `plan_ibfk_2` (`P_id`),
  CONSTRAINT `plan_ibfk_1` FOREIGN KEY (`P_name`) REFERENCES `film` (`F_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `plan_ibfk_2` FOREIGN KEY (`P_id`) REFERENCES `theatre` (`T_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `S_id` int(11) NOT NULL,
  `S_number` varchar(4) NOT NULL,
  `S_state` varchar(2) NOT NULL,
  `S_time` varchar(40) NOT NULL,
  `S_start` varchar(10) NOT NULL,
  KEY `seat_ibfk_1` (`S_id`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`S_id`) REFERENCES `theatre` (`T_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `theatre`;
CREATE TABLE `theatre` (
  `T_id` int(11) NOT NULL,
  `T_name` varchar(20) NOT NULL,
  `T_rows` int(11) NOT NULL,
  `T_cols` int(11) NOT NULL,
  `T_desc` varchar(80) NOT NULL,
  PRIMARY KEY (`T_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

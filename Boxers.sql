SELECT * FROM boxing.Boxers;CREATE TABLE `Boxers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `str` int(3) DEFAULT NULL,
  `spd` int(3) DEFAULT NULL,
  `agl` int(3) DEFAULT NULL,
  `cnd` int(3) DEFAULT '0',
  `agg` int(2) DEFAULT NULL,
  `def` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

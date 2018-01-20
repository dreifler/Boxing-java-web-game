CREATE TABLE `Boxers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `str` int(3) DEFAULT NULL,
  `spd` int(3) DEFAULT NULL,
  `agl` int(3) DEFAULT NULL,
  `cnd` int(3) DEFAULT '0',
  `agg` int(2) DEFAULT NULL,
  `def` int(2) DEFAULT NULL,
  `opponent` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `OppID_idx` (`opponent`),
  CONSTRAINT `OppID` FOREIGN KEY (`opponent`) REFERENCES `Boxers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

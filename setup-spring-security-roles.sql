
USE `boxing`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('john','{bcrypt}$2a$04$VZR9S21U2ZMz4NKMWHlGoOeesi2q2w3LFXGX/oUGS0AcrbVSHE6xS',1),
('mary','{bcrypt}$2a$04$7Fdo6Zi8RaRBWYVO0nhIg.R1C0o20zTFelBAEBUTGH1zYV6PQqR2G',1),
('darren','{bcrypt}$2a$04$VZR9S21U2ZMz4NKMWHlGoOeesi2q2w3LFXGX/oUGS0AcrbVSHE6xS',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('john','ROLE_PLAYER'),
('mary','ROLE_PLAYER'),
('mary','ROLE_ADMIN'),
('darren','ROLE_PLAYER'),
('darren','ROLE_ADMIN'),
('darren','ROLE_PROG');



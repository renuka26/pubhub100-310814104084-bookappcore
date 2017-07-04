USE `bookapp_db`;
CREATE TABLE `bookapp_db`.`users123`(  
  `id` INT(150) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50),
  `email_id` VARCHAR(50),
  `password` VARCHAR(50),
  `active` INT DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX (`email_id`)
);

CREATE TABLE `bookapp_db`.`books`(  
  `bookid` INT(150) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50),
  `price` INT(50),
  PRIMARY KEY (`bookid`)
  
);

INSERT INTO `users123`(`name`,`email_id`,`password`) VALUES('renuka','renuka@gmail.com','26-10-1996');
INSERT INTO `books`(`name`,`price`)VALUES('python',890);
SELECT NAME FROM `users123` WHERE `email_id`='renukatamilarasan1@gmail.com' AND `password`='26-10-1996';
UPDATE `books` SET `price`=1000 WHERE `name`='python';
DELETE FROM `books` WHERE `NAME`='python';
INSERT INTO`books`(`NAME`,`price`) VALUES('java',900);
INSERT INTO`books`(`NAME`,`price`) VALUES('java',7890);
INSERT INTO`books`(`NAME`,`price`) VALUES('python',230);
INSERT INTO`books`(`NAME`,`price`) VALUES('c',9000);
SELECT `NAME`,`price` FROM `books`;
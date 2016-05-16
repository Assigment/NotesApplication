CREATE DATABASE  IF NOT EXISTS `notesapplication`;
USE `notesapplication`;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_updated_time` datetime DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

--
-- Table structure for table `Note`
--
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `note_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` varchar(50) DEFAULT NULL,
  `last_updated_time` varchar(50) DEFAULT NULL,
  `note_text` varchar(1000) NOT NULL,
  `title` varchar(50) NOT NULL,
  `id` bigint(20) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  KEY `FK_n36jp4t7bvd83vfl04wqptc6r` (`id`),
  CONSTRAINT `FK_n36jp4t7bvd83vfl04wqptc6r` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


--
-- insert statement for user table
--

INSERT INTO `users` (`id`,`created_time`,`email`,`last_updated_time`,`password`) VALUES (110,'2016-05-15 02:27:08','dheeraj25in@gmail.com','2016-05-15 02:27:08','abc@1234');

INSERT INTO `users` (`id`,`created_time`,`email`,`last_updated_time`,`password`) VALUES (111,'2016-05-15 02:27:08','dheeraj237357in@gmail.com','2016-05-15 02:27:08','xyz@1234');

INSERT INTO `users` (`id`,`created_time`,`email`,`last_updated_time`,`password`) VALUES (112,'2016-05-15 02:27:08','vinayak@gmail.com','2016-05-15 02:27:08','vinayak@123');

INSERT INTO `users` (`id`,`created_time`,`email`,`last_updated_time`,`password`) VALUES (113,'2016-05-15 02:27:09','Sudheer@gmail.com','2016-05-15 02:27:09','sudheer@123');

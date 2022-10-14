CREATE DATABASE cats;
USE cats;

CREATE TABLE `cats` (
  `id` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `temperament` longtext NOT NULL,
  `origin` varchar(80) NOT NULL,
  `description` longtext NOT NULL,
  `wikipedia_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

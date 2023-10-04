/* P11 - Movies Database
Using SQL queries create Movies database with the following entities:
•directors (id, director_name, notes) 
•director_name cannot be null
•genres (id, genre_name, notes) 
•genre_name cannot be null
•categories (id, category_name, notes)  
•category_name cannot be null
•movies (id, title, director_id, copyright_year, length, genre_id, 
category_id, rating, notes)
•	title cannot be null
Set most appropriate data types for each column. Set primary key to each table. 
Populate each table with 5 records. Make sure the columns that are present in 
2 tables would be of the same data type. Consider which fields are always 
required and which are optional. */

CREATE DATABASE `Movies`;
USE `Movies`;

CREATE TABLE `directors`(
`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
`director_name` VARCHAR(15) NOT NULL,
`notes` TEXT NULL
);

CREATE TABLE `genres`(
`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
`genre_name` VARCHAR(15) NOT NULL,
`notes` TEXT NULL
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`category_name` VARCHAR(15) NOT NULL,
`notes` TEXT NULL
);

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`title` VARCHAR(30) NOT NULL,
`director_id` INT,
`copyright_year` DATE NULL,
`length` INT NULL,
`genre_id` INT,
`category_id` INT,
 `rating` DOUBLE NULL,
 `notes` TEXT NULL
);

INSERT INTO `directors`(`id`, `director_name`)
VALUES
('1', 'Roberto Spasov'),
('2', 'Gosho Petrov'),
('3', 'LUD Petrov'),
('4', 'GEORGI Petrov'),
('5', 'Ivan Petrov');

INSERT INTO `genres`(`id`, `genre_name`)
VALUES
('1', 'Comedy'),
('2', 'Action'),
('3', 'Adventure'),
('4', 'Drama'),
('5', 'Romance');

INSERT INTO `categories`(`id`, `category_name`)
VALUES
('1', 'GOOD'),
('2', 'NICE'),
('3', 'YES'),
('4', 'NOT VERY GOOD'),
('5', 'it\'Okay');

INSERT INTO `movies`(`id`, `title`)
VALUES
('1', 'MOVIE'),
('2', 'MOVIE1'),
('3', 'MOVIE2'),
('4', 'MOVIE3'),
('5', 'MOVIE4');
 
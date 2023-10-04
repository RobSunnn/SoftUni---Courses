/* P06 - Create Table People
Using SQL query create table "people" with columns:
•id – unique number for every person there will be no more than 231-1people. (Auto incremented)
•name – full name of the person will be no more than 200 Unicode characters. (Not null)
•picture – image with size up to 2 MB. (Allow nulls)
•height –  In meters. Real number precise up to 2 digits after floating point. (Allow nulls)
•weight –  In kilograms. Real number precise up to 2 digits after floating point. (Allow nulls)
•gender – Possible states are m or f. (Not null)
•birthdate – (Not null)
•biography – detailed biography of the person it can contain max allowed Unicode characters. (Allow nulls)
      Make id primary key. Populate the table with 5 records. */

CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB NULL,
`height` DOUBLE(5, 2) NULL,
`weight` DOUBLE(5, 2) NULL,
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT NULL
);

INSERT INTO `people`(`id`, `name`, `gender`, `birthdate`)
VALUES
('1', 'Ivan', 'm', '990301'),
('2', 'Pesho', 'm', '960201'),
('3', 'Gosho', 'm', '910222'),
('4', 'Robi', 'm', '990304'),
('5', 'Nati', 'f', '990304');

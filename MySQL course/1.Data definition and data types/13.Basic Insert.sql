/* P13 - Basic Insert
Now create bigger database called soft_uni. You will use database in the future tasks.
 It should hold information about
•towns (id, name)
•addresses (id, address_text, town_id)
•departments (id, name)
•employees (id, first_name, middle_name, last_name, job_title,
 department_id, hire_date, salary, address_id)
Id columns are auto incremented starting from 1 and increased by 1 (1, 2, 3, 4…).
 Make sure you use appropriate data types for each column.
 Add primary and foreign keys as constraints for each table. Use only SQL queries.
 Consider which fields are always required and which are optional.
Do not submit creation of database only the insert statements.  */

CREATE schema `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`address_text` TEXT NOT NULL,
`town_id` INT NOT NULL
);

CREATE TABLE `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(50) NOT NULL
);


CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(30) NOT NULL,
`middle_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`job_title` VARCHAR(50) NOT NULL,
`department_id` INT NOT NULL,
`hire_date` DATE NOT NULL,
`salary` DOUBLE NOT NULL,
`address_id` INT  NULL
);


ALTER TABLE `addresses`
ADD CONSTRAINT fk_addresses_towns
FOREIGN KEY `addresses`(`town_id`)
REFERENCES `towns`(`id`);

ALTER TABLE `employees`
ADD CONSTRAINT fk_employees_department
FOREIGN KEY `employees`(`department_id`)
REFERENCES `departments`(`id`);

ALTER TABLE `employees`
ADD CONSTRAINT fk_employees_address
FOREIGN KEY `employees`(`address_id`)
REFERENCES `addresses`(`id`);

INSERT INTO `towns` (`id`, `name`)
VALUES 
('1', 'Sofia'),
('2', 'Plovdiv'),
('3', 'Varna'),
('4', 'Burgas');

INSERT INTO `departments`(`id`, `name`)
VALUES
('1', 'Engineering'),
('2', 'Sales'),
('3', 'Marketing'),
('4', 'Software Development'),
('5', 'Quality Assurance');

INSERT INTO `employees` (`first_name`, `middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02	', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);

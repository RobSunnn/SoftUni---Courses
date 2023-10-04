/*  P12 - Car Rental Database
 Using SQL queries create car_rental database with the following entities:
•categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
•cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
•employees (id, first_name, last_name, title, notes)
•customers (id, driver_licence_number, full_name, address, city, zip_code, notes)
•rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level,
 kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date,
total_days, rate_applied, tax_rate, order_status, notes)
Set most appropriate data types for each column.
 Set primary key to each table. Populate each table with 3 records. 
Make sure the columns that are present in 2 tables would be of the same data type.
 Consider which fields are always required and which are optional.  */

CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`category` VARCHAR(30)  NOT NULL, 
`daily_rate` DOUBLE NULL, 
`weekly_rate` DOUBLE NULL, 
`monthly_rate` DOUBLE NULL, 
`weekend_rate` DOUBLE NULL);

INSERT INTO `categories`(`id`, `category`)
VALUES
('1', 'value1'),
('2', 'value2'),
('3', 'value3');

CREATE TABLE `cars`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
`plate_number` VARCHAR(15) UNIQUE NOT NULL, 
`make` VARCHAR(15) NOT NULL, 
`model` VARCHAR(15) NOT NULL, 
`car_year` YEAR NOT NULL, 
`category_id` INT , 
`doors` INT NULL, 
`picture` BLOB NULL, 
`car_condition` TEXT NULL, 
`available` BOOLEAN );

INSERT INTO `cars`(`id`, `plate_number`, `make`, `model`, `car_year`, `available`)
VALUES
('1', 'SW', 'car1', 'car1', '99', true),
('2', 'SWW', 'car2', 'car2', '99', true),
('3', 'SWWW', 'car3', 'car3', '99', true);	

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
`first_name` VARCHAR(15) NOT NULL, 
`last_name` VARCHAR(15) NOT NULL, 
`title` VARCHAR(15) NULL, 
`notes` TEXT NULL);

INSERT INTO  `employees`(`id`, `first_name`, `last_name`)
VALUES
('1', 'Robbie', 'Spasov'),
('2', 'Nathalie', 'Spasova'),
('3', 'Dani', 'Spasova');

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
`driver_licence_number` INT NOT NULL , 
`full_name` VARCHAR(31) NOT NULL, 
`address` VARCHAR(50) NOT NULL, 
`city` VARCHAR(20) NOT NULL, 
`zip_code` INT NOT NULL, 
`notes`TEXT NULL);

INSERT INTO `customers`(`id`, `driver_licence_number`, `full_name`, `address`, `city`, `zip_code`)
VALUES
('1', '123', 'Name1 name1', 'address1', 'city1', '1000'),
('2', '1234', 'Name2 name2', 'address2', 'city2', '1001'),
('3', '12345', 'Name3 name3', 'address3', 'city3', '1010');

CREATE TABLE `rental_orders`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL, 
`employee_id` INT NOT NULL, 
`customer_id` INT NOT NULL, 
`car_id` INT NOT NULL, 
`car_condition` TEXT NULL, 
`tank_level` INT NOT NULL, 
`kilometrage_start` INT(255) NOT NULL, 
`kilometrage_end`INT (255)  NULL, 
`total_kilometrage` INT(255)  NULL, 
`start_date` DATE NOT NULL, 
`end_date` DATE NOT NULL, 
`total_days` INT NOT NULL, 
`rate_applied` DOUBLE NULL, 
`tax_rate` DOUBLE NULL, 
`order_status` VARCHAR(30) NOT NULL, 
`notes` TEXT NULL);

INSERT INTO `rental_orders`(`id`, `employee_id`, `customer_id`, `car_id`,
`tank_level`, `kilometrage_start`, `start_date`, `end_date`, `total_days`, `order_status`)
VALUES
('1', '1', '1', '1', '1', '1', '230420', '230429', '6', 'In Progress'),
('2', '2', '2', '2', '2', '2', '230420', '230429', '6', 'In Progress'),
('3', '3', '3', '3', '3', '3', '230420', '230429', '6', 'In Progress');
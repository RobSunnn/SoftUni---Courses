/* P07 - 7.	Create Table Users
Using SQL query create table users with columns:
•id – unique number for every user. There will be no more than 263-1 users. (Auto incremented)
•username – unique identifier of the user will be no more than 30 characters (non Unicode). (Required)
•password – password will be no longer than 26 characters (non Unicode). (Required)
•profile_picture – image with size up to 900 KB.   
•last_login_time
•is_deleted – shows if the user deleted his/her profile. Possible states are true or false.   */

CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`username` NVARCHAR(30) UNIQUE NOT NULL,
`password` NVARCHAR(26) NOT NULL,
`profile_picture` BLOB NULL,
`last_login_time` DATETIME NULL,
`is_deleted` BOOLEAN 
);

INSERT INTO `users`(`id`, `username`, `password`, `is_deleted`)
VALUES
('1', 'Green', '1234', false),
('2', 'Gr33n', '1234', false),
('3', 'Gre3n', '1234', false),
('4', 'Greeen', '1234', false),
('5', 'Greeeeen', '1234', false);
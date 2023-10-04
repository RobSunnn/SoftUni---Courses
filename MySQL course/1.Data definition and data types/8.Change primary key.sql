/* 08 - Change Primary Key
sing SQL queries modify table users from the previous task.
irst remove current primary key then create new primary key 
hat would be combination of fields id and username. 
he initial primary key name on id is pk_users.  */

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY `pk_users`(`id`, `username`);

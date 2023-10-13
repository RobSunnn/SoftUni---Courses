/* P09 - Length of Last Name
 Write a SQL query to find the first and last names of 
 all employees whose last name is exactly 5 characters long. */

SELECT `first_name`, `last_name` FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;
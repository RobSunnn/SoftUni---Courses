/* P08 - Find Names of All Employees by salary in Range
 Write a SQL query to find the first name, last name and
 job title of all employees whose salary is in the range
 [20000, 30000]. Sort the information by id. */

SELECT `first_name`, `last_name`, `job_title` 
FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000;

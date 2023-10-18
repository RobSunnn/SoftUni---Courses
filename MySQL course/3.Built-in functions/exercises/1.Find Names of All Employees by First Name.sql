/* P01 - Find Names of All Employees by First Name
 Write a SQL query to find first and last names of all employees
 whose first name starts with "Sa" (case insensitively).
 Order the information by id. */

SELECT `first_name`, `last_name` FROM `employees`
WHERE LOWER(`first_name`) LIKE 'sa%'
ORDER BY `employee_id`;
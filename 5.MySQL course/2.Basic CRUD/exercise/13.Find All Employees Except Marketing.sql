/* P13 - Find All Employees Except Marketing 
 Write a SQL query to find the first and last names of all employees
 whose department ID is different from 4.   */

SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` NOT IN(4);

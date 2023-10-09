/* P15 - Create View Employees with Salaries 
 Write a SQL query to create a view v_employees_salaries
 with first name, last name and salary for each employee.  */

CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary` 
FROM `employees`;
SELECT * FROM `v_employees_salaries`;
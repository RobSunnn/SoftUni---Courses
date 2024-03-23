/* P01 - Employees with Salary Above 35000
Create stored procedure usp_get_employees_salary_above_35000 that returns 
all employees' first and last names for whose salary is above 35000. 
The result should be sorted by first_name then by last_name
alphabetically, and id ascending.           */

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE usp_get_employees_salary_above_35000 ()
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
WHERE e.salary > 35000
ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

DELIMITER ;

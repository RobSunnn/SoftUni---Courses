/* P02 - Employees with Salary Above Number
Create stored procedure usp_get_employees_salary_above that accept a 
decimal number (with precision, 4 digits after the decimal point) as parameter 
and return all employee's first and last names whose salary is above or
equal to the given number. The result should be sorted by 
first_name then by last_name alphabetically and id ascending.  */

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE usp_get_employees_salary_above (salary_above DECIMAL(10,4))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
WHERE e.salary >= salary_above
ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

DELIMITER ;

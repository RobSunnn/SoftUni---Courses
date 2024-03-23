/* P06 - Employees by Salary Level
Write a stored procedure usp_get_employees_by_salary_level that 
receive as parameter level of salary(low, average or high) and print 
the names of all employees that have given level of salary. 
The result should be sorted by first_name then by last_name both 
in descending order.      */

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(7))
BEGIN
SELECT e.first_name, e.last_name FROM employees AS e
WHERE ufn_get_salary_level(e.salary) = salary_level
ORDER BY e.first_name DESC, e.last_name DESC;
END$$
DELIMITER ;
CALL usp_get_employees_by_salary_level('High');
/* P04 - Employees from Town
Write a stored procedure usp_get_employees_from_town that accepts 
town_name as parameter and return the employees' first and last name 
that live in the given town. 
The result should be sorted by first_name then by
last_name alphabetically and id ascending.  */

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town (town_name VARCHAR(30))
BEGIN
	SELECT e.first_name, e.last_name FROM employees AS e
    JOIN addresses AS a USING(address_id)
    JOIN towns AS t USING(town_id)
    WHERE t.name LIKE town_name
    ORDER BY e.first_name, e.last_name, e.employee_id;

END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');
/* P20 - Increase Salaries 
 Write a SQL query to increase salaries of all employees 
 that are in the Engineering, Tool Design, Marketing or 
 Information Services department by 12%.
 Then select Salaries column from the Employees table. */

UPDATE  `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN(1,2,4,11);

SELECT `salary` FROM `employees`
ORDER BY `employee_id`;
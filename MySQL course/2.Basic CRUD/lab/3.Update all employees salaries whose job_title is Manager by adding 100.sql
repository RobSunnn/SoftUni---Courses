/*  P03 - Update all employees' salaries whose job_title is "Manager" by adding 100. 
 Retrieve information about salaries from table employees.   */

UPDATE employees `salary`
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';
SELECT `salary` FROM `employees`;
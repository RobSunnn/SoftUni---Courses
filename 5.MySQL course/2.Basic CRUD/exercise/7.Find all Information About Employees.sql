/*  P07 - Find all Information About Employees
 Write a SQL query to find all information about the
 employees whose job title is "Sales Representative".
 Sort the information by id. */ 

SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;
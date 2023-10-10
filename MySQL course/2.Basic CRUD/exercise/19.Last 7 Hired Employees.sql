/* P19 - Last 7 Hired Employees 
 Write a SQL query to find last 7 hired employees.
 Select their first, last name and their hire date.   */

SELECT `first_name`,`last_name`,`hire_date` FROM `employees`
ORDER BY `hire_date` DESC
LIMIT 7; 
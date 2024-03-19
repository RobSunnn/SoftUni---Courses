/* P03 - Find First Names of All Employees
 Write a SQL query to find the first names of all employees in the
 departments with ID 3 or 10 and whose hire year is between 1995 and 2005
 inclusively. Order the information by id. */

SELECT `first_name` FROM `employees`
WHERE `department_id` IN(3, 10) AND
`hire_date`  BETWEEN '1995-01-01' AND '2005-12-31'
ORDER BY `employee_id`;
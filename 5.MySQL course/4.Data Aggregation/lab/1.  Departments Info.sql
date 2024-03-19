/* P01 - Departments Info
Write a query to count the number of employees in each department by id.
Order the information by deparment_id, then by Number of employees.
Submit your queries with the MySQL prepare DB & run queries
strategy. */

SELECT department_id, COUNT(department_id)
AS 'Number of employees'
FROM employees
GROUP BY(department_id);

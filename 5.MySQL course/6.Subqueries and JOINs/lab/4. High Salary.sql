/* P04 - High Salary
Write a query to count the number of employees who 
receive salary higher than the average.   */

SELECT COUNT(*) FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
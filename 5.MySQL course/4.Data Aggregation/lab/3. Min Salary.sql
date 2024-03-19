/* P03 - Min Salary
Write a query to retrieve information about the departments grouped
by department_id with minimum salary higher than 800. 
Round the salary result to two digits after the decimal point. */

SELECT department_id, ROUND(MIN(salary)) AS 'Min Salary'
FROM employees
WHERE salary > 800 AND department_id = 1
GROUP BY department_id;
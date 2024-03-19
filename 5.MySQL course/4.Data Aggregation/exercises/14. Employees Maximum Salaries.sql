/* P14 - Employees Maximum Salaries
Find the max salary for each department. 
Filter those which have max salaries not in the range 30000 and 70000.
Sort result by department_id in increasing order.  */

SELECT 
    department_id, MAX(salary) AS 'max_salary'
FROM
    employees
GROUP BY (department_id)
HAVING max_salary < 30000 OR max_salary > 70000
ORDER BY department_id ASC;
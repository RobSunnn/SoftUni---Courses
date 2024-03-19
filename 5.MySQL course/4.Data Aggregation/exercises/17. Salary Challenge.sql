/* P17 - Salary Challenge**
Write a query that returns:
• first_name
• last_name
• department_id
for all employees who have salary higher than the 
average salary of their respective departments.
Select only the first 10 rows. Order by department_id, employee_id.  */

SELECT 
    first_name, last_name, department_id
FROM
    employees AS e
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees
        WHERE
            e.department_id = department_id)
ORDER BY department_id , employee_id
LIMIT 10;
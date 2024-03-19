/* P18 - Departments Total Salaries
Create a query which shows the total sum of salaries for each department. 
Order by department_id. Your query should return:  • department_id */

SELECT 
    department_id, SUM(salary)
FROM
    employees
GROUP BY department_id
ORDER BY department_id;
/* P16 - 3rd Highest Salary*
Find the third highest salary in each department if there is such.
Sort result by department_id in increasing order */

SELECT 
    department_id,
    (SELECT DISTINCT
            salary
        FROM
            employees as e2
            WHERE e1.department_id = e2.department_id	
        ORDER BY salary DESC
        LIMIT 2 , 1) AS third_highest_salary
FROM
    employees as e1
GROUP BY department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY department_id;
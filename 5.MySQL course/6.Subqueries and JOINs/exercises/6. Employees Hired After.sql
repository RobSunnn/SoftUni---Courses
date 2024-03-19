/* P06 - Employees Hired After
Write a query that selects:
• first_name
• last_name
• hire_date
• dept_name
Filter only employees hired after 1/1/1999 
and from either the "Sales" or the "Finance" departments. 
Sort the result by hire_date (ascending).    */

SELECT 
    e.first_name, e.last_name, e.hire_date, d.`name`
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    e.hire_date > '1999-01-01'
        AND d.name = 'Sales'
        OR d.name = 'Finance'
ORDER BY e.hire_date ASC;
/* P03 - Sales Employee
Write a query that selects:
• employee_id
• first_name
• last_name
• department_name
Sort the result by employee_id in descending order. 
Select only employees from the "Sales" department.   */

SELECT 
    e.employee_id, e.first_name, e.last_name, d.`name`
FROM
    employees AS e
        JOIN
    departments AS d USING (department_id)
WHERE
    d.`name` LIKE ('Sales')
ORDER BY e.employee_id DESC;
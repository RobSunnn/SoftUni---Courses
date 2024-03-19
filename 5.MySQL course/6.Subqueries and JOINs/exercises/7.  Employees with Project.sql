/* P07 - Employees with Project
Write a query that selects:
• employee_id
• first_name
• project_name
Filter only employees with a project, which has started after
13.08.2002 and it is still ongoing (no end date). 
Return the first 5 rows sorted by first_name 
then by project_name both in ascending order.    */

SELECT 
    e.employee_id, e.first_name, p.`name`
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
        JOIN
    projects AS p ON p.project_id = ep.project_id
WHERE
    DATE(p.start_date) > '2002-08-13'
        AND DATE(p.end_date) IS NULL
GROUP BY e.employee_id , e.first_name , p.name
ORDER BY e.first_name ASC , p.name ASC
LIMIT 5;

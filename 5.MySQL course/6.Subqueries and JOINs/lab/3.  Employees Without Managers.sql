/* P03 - Employees Without Managers
Write a query to get information about 
employee_id, first_name, last_name, department_id and salary
for all employees who don't have a manager.    */

SELECT employee_id, first_name, last_name,
department_id, salary
FROM employees AS e
WHERE e.manager_id IS NULL;

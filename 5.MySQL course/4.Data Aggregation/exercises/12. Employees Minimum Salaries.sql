/* P12 - Employees Minimum Salaries
That's it! You no longer work for Mr. Bodrog. You have decided to find a proper job 
as an analyst in SoftUni. It's not a surprise that you will use the soft_uni database.
Select the minimum salary from the employees for departments with ID (2,5,7)
but only for those who are hired after 01/01/2000.
Sort result by department_id in ascending order.  */

SELECT department_id, MIN(salary) FROM employees
WHERE hire_date > 2000-01-01
GROUP BY (department_id)
HAVING department_id IN(2,5,7)
ORDER BY department_id;
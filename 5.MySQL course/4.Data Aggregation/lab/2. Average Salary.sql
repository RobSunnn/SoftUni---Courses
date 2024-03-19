/* P02 - Average Salary
Write a query to calculate the average salary in each department.
Order the information by department_id.
Round the salary result to two digits after the decimal point. */

SELECT department_id, ROUND(AVG(salary), 2)
AS 'Average Salary'
FROM employees
GROUP BY(department_id);
/* P04 - Find All Employees Except Engineers
 Write a SQL query to find the first and last names of all
 employees whose job titles does not contain "engineer".
 Order the information by id.    */

SELECT `first_name`, `last_name` FROM `employees`
WHERE LOWER(`job_title`) NOT LIKE '%engineer%'
ORDER BY `employee_id`;
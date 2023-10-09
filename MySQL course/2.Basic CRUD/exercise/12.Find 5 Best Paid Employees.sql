/* P12 - Find 5 Best Paid Employees 
 Write SQL query to find first and last names about 5
 best paid Employees ordered descending by their salary. */

SELECT `first_name`, `last_name` FROM `employees`
ORDER BY `salary` DESC
LIMIT 5;

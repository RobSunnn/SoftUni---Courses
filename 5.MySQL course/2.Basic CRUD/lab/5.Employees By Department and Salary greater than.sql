/* P05 - Write a query to retrieve information about employees, 
who are in department 4 and has a salary higher or equal to 1000.
Order the information by id. */

SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id`;
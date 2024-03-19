/* P02 - Write a query to select all employees (id, first_name and last_name (as full_name),
job_title, salary) whose salaries are higher than 1000.00, ordered by id.
Concatenate fields first_name and last_name into 'full_name'.   */

SELECT `id`, CONCAT_WS(' ', `first_name`, `last_name`) AS 'full_name', `job_title`, `salary`
FROM `employees`
WHERE `salary` > 1000
ORDER BY id;
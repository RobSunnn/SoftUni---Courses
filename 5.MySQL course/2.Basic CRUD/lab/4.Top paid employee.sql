/*  P04 - Write a query to create a view that selects all information about 
the top paid employee from the "employees" table in the hotel database. */

SELECT * FROM `employees` 
ORDER BY `salary` DESC
LIMIT 1;
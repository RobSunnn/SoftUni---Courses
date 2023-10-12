/* P06 - Find Towns Starting With
 Write a SQL query to find all towns that start with letters
 M, K, B or E (case insensitively).
 Order them alphabetically by town name. */

SELECT * FROM `towns`
WHERE LOWER(`name`) LIKE 'm%' OR LOWER(`name`) LIKE 
'k%' OR LOWER(`name`) LIKE 'b%' OR LOWER(`name`) LIKE 'e%'
ORDER BY `name`;

/* P07 - Find Towns Not Starting With
 Write a SQL query to find all towns that do not start with letters
 R, B or D (case insensitively). Order them alphabetically by name.  */

SELECT * FROM `towns`
WHERE LOWER(`name`) NOT LIKE 'r%' AND LOWER(`name`) NOT LIKE 
'b%' AND LOWER(`name`) NOT LIKE 'd%' 
ORDER BY `name`;
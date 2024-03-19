/* P 05 - Find Towns with Name Length
 Write a SQL query to find town names that are 5 or 6 symbols
 long and order them alphabetically by town name. */

SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) = 5 OR CHAR_LENGTH(`name`) = 6
ORDER BY `name`;
/* P03 - Town Names Starting With
Write a stored procedure usp_get_towns_starting_with that accept string as 
parameter and returns all town names starting with that string. 
The result should be sorted by town_name alphabetically.        */

DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_towns_starting_with`(prefix VARCHAR(10))
BEGIN
SELECT  t.name FROM towns AS t
WHERE t.name LIKE CONCAT(prefix, '%')
ORDER BY t.name;
END$$

DELIMITER ;
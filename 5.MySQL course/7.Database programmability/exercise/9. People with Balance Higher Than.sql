/* P09 - People with Balance Higher Than
Your task is to create a stored procedure usp_get_holders_with_balance_higher_than
that accepts a number as a parameter and returns all people who have more money 
in total of all their accounts than the supplied number. 
The result should be sorted by account_holders.id ascending.   */

DELIMITER $$ 
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(numb INT)
BEGIN
SELECT first_name, last_name FROM account_holders AS ah
JOIN accounts AS a ON ah.id = a.account_holder_id
GROUP BY first_name, last_name,ah.id
HAVING SUM(balance) > numb
ORDER BY ah.id;
END $$
DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);
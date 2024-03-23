/* P08 - Find Full Name
You are given a database schema with tables:
• account_holders(id (PK), first_name, last_name, ssn)
and
• accounts(id (PK), account_holder_id (FK), balance).
Write a stored procedure usp_get_holders_full_name that 
selects the full names of all people. The result should be
sorted by full_name alphabetically and id ascending.   */

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
  SELECT CONCAT_WS(' ', first_name, last_name) AS full_name
  FROM account_holders
  ORDER BY full_name, id;
END $$
DELIMITER ;

CALL usp_get_holders_full_name;
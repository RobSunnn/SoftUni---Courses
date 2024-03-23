/* P13 - Withdraw Money
Add stored procedures usp_withdraw_money(account_id, money_amount) that operate 
in transactions. Make sure to guarantee withdraw is done only when balance is enough 
and money_amount is valid positive number. Work with precision up to fourth 
sign after decimal point. The procedure should produce exact results
working with the specified precision.    */

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF money_amount > 0 AND 
(SELECT balance from accounts AS a WHERE a.id = account_id ) >= money_amount
THEN 
UPDATE accounts AS a
SET  a.balance = a.balance - money_amount 
WHERE a.id = account_id; 
ELSE ROLLBACK;
END IF;
COMMIT;
END $$
DELIMITER ;
/* P12 - Deposit Money
Add stored procedure usp_deposit_money(account_id, money_amount) 
that operate in transactions. Make sure to guarantee valid positive money_amount 
with precision up to fourth sign after decimal point. 
The procedure should produce exact results working with the specified precision.   */

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
START TRANSACTION;
IF money_amount > 0 THEN UPDATE accounts SET balance = balance + money_amount
WHERE account_id = id;
ELSE ROLLBACK;
END IF;
COMMIT;
END $$
DELIMITER ;

/* P04 - Smallest Deposit Group Per Magic Wand Size
Select the deposit group with the lowest average wand size. */

SELECT 
    deposit_group
FROM
    wizzard_deposits
GROUP BY (deposit_group)
HAVING AVG(magic_wand_size)
LIMIT 1;

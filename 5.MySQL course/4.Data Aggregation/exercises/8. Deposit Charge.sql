/* P08 - Deposit Charge
Create a query that selects:
• Deposit group
• Magic wand creator
• Minimum deposit charge for each group
Group by deposit_group and magic_wand_creator.
Select the data in ascending order by magic_wand_creator and deposit_group. */

SELECT 
    deposit_group,
    magic_wand_creator,
    MIN(deposit_charge) AS 'min_deposit_charge'
FROM
    wizzard_deposits
GROUP BY (deposit_group) , (magic_wand_creator)
ORDER BY magic_wand_creator ASC , deposit_group ASC;
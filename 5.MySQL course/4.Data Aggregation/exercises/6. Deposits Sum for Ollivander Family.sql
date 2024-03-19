/* P06 - Deposits Sum for Ollivander Family
Select all deposit groups and its total deposit sum but only for the
wizards who has their magic wand crafted by Ollivander family.
 Sort result by deposit_group alphabetically.   */
 
SELECT 
    deposit_group, SUM(deposit_amount)
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY (deposit_group)
ORDER BY deposit_group ASC;
 
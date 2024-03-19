/* P10 -  First Letter
Write a query that returns all unique wizard first letters of their first 
names only if they have deposit of type Troll Chest.
Order them alphabetically. Use GROUP BY for uniqueness.  */

SELECT 
    LEFT(first_name, 1) AS 'first_letter'
FROM
    wizzard_deposits
WHERE
    deposit_group = 'Troll Chest'
GROUP BY (first_letter)
ORDER BY first_letter ASC;
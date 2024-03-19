/* P02 - Addresses with Towns
Write a query that selects:
• first_name
• last_name
• town
• address_text
Sort the result by first_name in ascending order 
then by last_name. Select first 5 employees.  */

SELECT 
    e.first_name, e.last_name, t.name, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
        JOIN
    towns AS t USING (town_id)
ORDER BY first_name ASC , last_name
LIMIT 5;
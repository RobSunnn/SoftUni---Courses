/* P14 - Countries with Rivers
Write a query that selects:
• country_name
• river_name
Find the first 5 countries with or without rivers in Africa. 
Sort them by country_name in ascending order.     */

SELECT 
    c.country_name, r.river_name
FROM
    countries_rivers AS cr
        RIGHT JOIN
    rivers AS r ON cr.river_id = r.id
        RIGHT JOIN
    countries AS c USING (country_code)
WHERE
    c.continent_code = 'AF'
GROUP BY c.country_name , r.river_name
ORDER BY c.country_name
LIMIT 5;
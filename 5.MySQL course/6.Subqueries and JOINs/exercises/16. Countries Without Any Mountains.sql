/* P16 - Countries Without Any Mountains
Find the count of all countries which don't have a mountain.   */

SELECT 
    COUNT(*) AS 'country_count'
FROM
    countries AS c
WHERE
    c.country_code NOT IN (SELECT 
            country_code
        FROM
            mountains_countries);
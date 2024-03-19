/* P15 - *Continents and Currencies
Write a query that selects:
• continent_code
• currency_code
• currency_usage
Find all continents and their most used currency. 
Filter any currency that is used in only one country. 
Sort the result by continent_code and currency_code.   */

SELECT 
    c.continent_code,
    c.currency_code,
    COUNT(*) AS 'currency_usage'
FROM
    countries AS c
GROUP BY c.continent_code , c.currency_code
HAVING currency_usage > 1
    AND currency_usage = (SELECT 
         COUNT(*) AS 'most_used'
    FROM
        countries AS co
    WHERE
        co.continent_code = c.continent_code
    GROUP BY co.currency_code
    ORDER BY most_used DESC
    LIMIT 1)
ORDER BY c.continent_code , c.currency_code;
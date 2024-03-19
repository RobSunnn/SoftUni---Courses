/* P13 - Count Mountain Ranges
Write a query that selects:
• country_code
• mountain_range
Filter the count of the mountain ranges in the United States, 
Russia and Bulgaria. Sort result by mountain_range
count in decreasing order.    */

SELECT 
    mc.country_code, COUNT(*) AS 'mountain_range'
FROM
    mountains_countries AS mc
WHERE
    mc.country_code IN ('BG' , 'RU', 'US')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;

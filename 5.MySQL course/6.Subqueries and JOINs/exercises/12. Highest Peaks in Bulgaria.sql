/*  P12 - Highest Peaks in Bulgaria
Write a query that selects:
• country_code 
• mountain_range
• peak_name
• elevation
Filter all peaks in Bulgaria with elevation over 2835. 
Return all rows sorted by elevation in descending order.    */

SELECT 
    mc.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    mountains AS m
        JOIN
    mountains_countries AS mc ON m.id = mc.mountain_id
        JOIN
    peaks AS p ON p.mountain_id = m.id
WHERE
    mc.country_code = 'BG'
        AND p.elevation > 2835
ORDER BY p.elevation DESC;

/* P15 - Show All Games with Duration and Part of the Day
 Find all games with their corresponding part of the day and duration.
 Parts of the day should be Morning (start time is >= 0 and < 12),
 Afternoon (start time is >= 12 and < 18),
 Evening (start time is >= 18 and < 24).
 Duration should be Extra Short (smaller or equal to 3),
 Short (between 3 and 6 including), Long (between 6 and 10 including)
 and Extra Long in any other cases or without duration. */

SELECT 
    `name`,
    CASE
        WHEN
            HOUR(`start`) >= 0
                AND HOUR(`start`) < 12
        THEN
            'Morning'
        WHEN
            HOUR(`start`) >= 12
                AND HOUR(`start`) < 18
        THEN
            'Afternoon'
        ELSE 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    `games`;
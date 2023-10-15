/* P11 - Mix of Peak and River Names
 Combine all peak names with all river names, so that the last letter
 of each peak name is the same as the first letter of its corresponding
 river name. Display the peak name, the river name, and the 
 obtained mix(converted to lower case).
 Sort the results by the obtained mix alphabetically. */

SELECT 
    p.peak_name,
    r.river_name,
    LOWER(CONCAT(p.peak_name,
                    SUBSTRING(r.river_name,
                        2,
                        CHAR_LENGTH(r.river_name)))) AS mix
FROM
    peaks AS p,
    rivers AS r
WHERE
    LOWER(RIGHT(p.peak_name, 1)) = LOWER(LEFT(r.river_name, 1))
ORDER BY mix;
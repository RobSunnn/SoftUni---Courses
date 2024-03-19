/* P09 - Peaks in Rila
Display all peaks for "Rila" mountain_range. Include:
• mountain_range
• peak_name
• peak_elevation
Peaks should be sorted by peak_elevation descending.   */

SELECT 
    m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM
    mountains AS m
        JOIN
    peaks AS p ON m.id = p.mountain_id
WHERE
    m.id = 17
    ORDER BY p.elevation DESC;



/* P09 - Age Groups
Write down a query that creates 7 different groups based on their age.
Age groups should be as follows:
• [0-10]
• [11-20]
• [21-30]
• [31-40]
• [41-50]
• [51-60]
• [61+]
The query should return:
• Age groups
• Count of wizards in it
Sort result by increasing size of age groups. */


SELECT 
    CASE
        WHEN age BETWEEN 0 AND 10 THEN '[0-10]' 
        WHEN age BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN age BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN age BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN age BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN age BETWEEN 51 AND  60 THEN '[51-60]'
        ELSE '[61+]'
    END AS 'age_group',
    COUNT(age) AS 'wizard_count'
FROM
    wizzard_deposits
    GROUP BY (age_group)
    ORDER BY age_group ASC;
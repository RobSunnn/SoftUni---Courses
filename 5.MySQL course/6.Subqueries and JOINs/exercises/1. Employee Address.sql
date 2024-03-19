/*  P01 - Employee Address
Write a query that selects:
• employee_id
• job_title
• address_id
• address_text
Return the first 5 rows sorted by address_id in ascending order.   */

SELECT 
    e.employee_id, e.job_title, a.address_id, a.address_text
FROM
    employees AS e
        JOIN
    addresses AS a USING (address_id)
ORDER BY address_id ASC
LIMIT 5;
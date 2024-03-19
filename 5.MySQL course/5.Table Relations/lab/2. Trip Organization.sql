/* P02 - Trip Organization
Write a query to retrieve information about SoftUni camp's transportation organization. 
Get information about the drivers (name and id) and their vehicle type. 
Submit your queries using the "MySQL prepare DB and Run Queries" strategy */

SELECT 
    driver_id,
    v.vehicle_type,
    CONCAT(first_name, ' ', last_name) AS 'full_name'
FROM
    campers AS c
        JOIN
    vehicles AS v ON c.id = v.driver_id;
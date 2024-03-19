/* P03 - SoftUni Hiking
Get information about the hiking routes – starting point and ending point, 
and their leaders – name and id. 
Submit your queries using the "MySQL prepare DB and Run Queries" strategy.   */

SELECT 
    starting_point,
    end_point,
    leader_id,
    CONCAT_WS(' ', first_name, last_name) AS 'leader_name'
FROM
    routes AS r
        JOIN
    campers AS c ON r.leader_id = c.id;

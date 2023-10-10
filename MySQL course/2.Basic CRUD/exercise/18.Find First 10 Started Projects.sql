/* P18 - Find First 10 Started Projects 
 Write a SQL query to find first 10 started projects.
 Select all information about them and sort them by start date,
 then by name. Sort the information by id.  */

SELECT * FROM `projects`
ORDER BY `start_date`, `name`, `project_id`
LIMIT 10;
/* P16 - Create View Employees with Job Titles 
 Write a SQL query to create view v_employees_job_titles with
 full employee name and job title.
 When middle name is NULL replace it with empty string (''). */

CREATE VIEW `v_employees_job_titles` AS
SELECT CONCAT_WS(' ',
`first_name`,
`middle_name`,
 `last_name`) AS `full_Name`, `job_title`
FROM `employees`;
SELECT * FROM `v_employees_job_titles`;
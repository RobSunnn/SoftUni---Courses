/* P04 - Days Lived
 Write a SQL query to calculate the days that #
 an author lived. Your query should return:
 Full Name – the full name of the author.
 Days Lived – days that he/she lived.
 NULL values mean that the author is still alive.    */

SELECT CONCAT(`first_name`,' ', `last_name`) 
AS 'Full Name', TIMESTAMPDIFF(day, `born`, `died`)
AS 'Days Lived'
FROM authors;

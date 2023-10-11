/* P02 - Write a SQL query to find books which titles 
 start with "The" and replace the substring with 3 asterisks.
 Retrieve data about the updated titles. Order the result by id.   */

UPDATE books
SET title = CONCAT('***', SUBSTRING(title, 4))
WHERE title LIKE 'The%';

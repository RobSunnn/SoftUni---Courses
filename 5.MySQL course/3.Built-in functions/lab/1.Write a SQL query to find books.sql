/* P01 - Write a SQL query to find books 
 which titles start with "The". Order the result by id   */

SELECT title FROM books
WHERE title LIKE 'The%';
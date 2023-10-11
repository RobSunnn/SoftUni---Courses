/* P03 - Write a SQL query to sum prices of all books.
 Format the output to 2 digits after decimal point    */

SELECT ROUND(SUM(cost), 2) FROM books;
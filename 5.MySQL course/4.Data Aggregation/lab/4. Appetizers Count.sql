/* P04 - Appetizers Count
Write a query to retrieve the count of all appetizers
(category id = 2) with price higher than 8. */

SELECT COUNT(category_id) FROM products
WHERE category_id = 2 AND price > 8;

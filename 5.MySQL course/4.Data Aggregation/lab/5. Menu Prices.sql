/* P05 - Menu Prices
Write a query to retrieve information about the prices of each category.
The output should consist of:
• Category_id
• Average Price
• Cheapest Product
• Most Expensive Product
See the examples for more information.
Round the results to 2 digits after the decimal point.  */

SELECT category_id ,
ROUND(AVG(price), 2)  AS 'Average Price',
ROUND(MIN(price), 2) AS 'Cheapest Product',
ROUND(MAX(price), 2) AS 'Most Expensive Product'
FROM products 
GROUP BY (category_id);
/* P02 - Towns Addresses
Write a query to get information about the addresses in the database, 
which are in San Francisco, Sofia or Carnation. 
Retrieve town_id, town_name, address_text. 
Order the result by town_id, then by address_id.   */

SELECT t.town_id, t.`name`, a.address_text FROM addresses AS a
JOIN towns as t
USING(town_id)
WHERE t.name IN('Sofia', 'San Francisco', 'Carnation')
ORDER BY town_id, address_id;
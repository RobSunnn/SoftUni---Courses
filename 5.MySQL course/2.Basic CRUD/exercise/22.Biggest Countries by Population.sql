/* P22 - Biggest Countries by Population 
 Find the 30 biggest countries by population from Europe. 
 Display the country name and population. Sort the results by
 population (from biggest to smallest), 
 then by country alphabetically.   */

SELECT `country_name`, `population` FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_name` ASC
LIMIT 30;

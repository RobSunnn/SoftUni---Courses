/* P13 - User Email Providers
 Find information about the email providers of all users.
 Display the user_name and the email provider.
 Sort the results by email provider alphabetically, then by username. */

SELECT `user_name`,
REGEXP_REPLACE(`email`, '.*@', '') AS `email provider`
FROM `users`
ORDER BY `email provider`, `user_name`;

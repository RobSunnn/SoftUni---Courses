/* P02 - Alter Minions Table
Before continuing with the next assignments,
 rename the town_id to id using Workbench's GUI.
Do not submit this query on the Judge System.
Change the structure of the Minions table to have new column town_id that
would be of the same type as the id column of towns table.
 Add new constraint that makes town_id foreign key and references to id column of 
towns table. */

ALTER TABLE `towns`
CHANGE COLUMN `town_id` `id` INT  AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY `minions`(`town_id`)
REFERENCES `towns`(`id`);
#P17 - Increase Employees Salary
#Use softuni database and increase the salary of all employees by 10%.
# Then select only salary column from the employees table. 

UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;
/* P05 - Salary Level Function
Write a function ufn_get_salary_level that receives salary 
of an employee and returns the level of the salary.
• If salary is < 30000 return "Low"
• If salary is between 30000 and 50000 (inclusive) return "Average"
• If salary is > 50000 return "High"   */

CREATE  FUNCTION `ufn_get_salary_level`(`level` INT) RETURNS varchar(10)
    DETERMINISTIC
BEGIN
DECLARE salary_Level VARCHAR(10);

IF `level` < 30000 THEN SET salary_Level = 'Low';
ELSEIF `level` BETWEEN 30000 AND 50000 THEN SET salary_Level = 'Average';
ELSE SET salary_Level = 'High';
END IF;
RETURN   salary_Level;
END

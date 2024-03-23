/* P07 - Define Function
Define a function ufn_is_word_comprised(set_of_letters varchar(50), 
word varchar(50)) that returns 1 or 0 depending on that if the word 
is a comprised of the given set of letters.   */


CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), 
word varchar(50))
RETURNS BIT
RETURN word REGEXP(concat('^[', set_of_letters, ']+$'));

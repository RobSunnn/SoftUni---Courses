/* P04 - Self-Referencing  */

CREATE TABLE teachers(
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`manager_id` INT,
CONSTRAINT fk_teacher_manager
FOREIGN KEY (`manager_id`)
REFERENCES teachers(`teacher_id`)
) AUTO_INCREMENT = 101;

INSERT INTO teachers(`name`)
VALUES
('John'),
('Maya'),
('Silvia'),
('Ted'),
('Mark'),
('Greta');

UPDATE teachers
SET manager_id = 106
WHERE teacher_id = 102 OR teacher_id = 103;

UPDATE teachers
SET manager_id= 105
WHERE teacher_id = 104;

UPDATE teachers 
SET 
    manager_id = 101
WHERE
    teacher_id = 105 OR teacher_id = 106;
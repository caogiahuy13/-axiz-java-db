DROP DATABASE axizdb_exam;

-- @ f[^x[Xμ¬
CREATE DATABASE axizdb_exam;

-- A e[uμ¬ ? »Μ1 
CREATE TABLE major (
	major_id INT PRIMARY KEY,
	major_name VARCHAR(50)
);

-- B e[uμ¬ ? »Μ2
CREATE TABLE student (
	student_id INT PRIMARY KEY,
	student_name VARCHAR(50),
	grade INT,
	hometown VARCHAR(50),
	major_id INT NOT NULL REFERENCES major(major_id)
);

-- C gmajorhe[uΦf[^o^
INSERT INTO major (major_id, major_name) VALUES 
	(1, 'pΆw'),
	(2, 'p»w'),
	(3, 'ξρHw'),
	(4, 'oΟw'),
	(5, 'ΫΆ»')
;

-- D gstudenthe[uΦf[^o^
INSERT INTO student (student_id, student_name, grade, hometown, major_id)
VALUES
	(1, 'Rc', 1, '{ι', 1),
	(2, 'c', 1, '', 2),
	(3, '²‘', 1, '', 3),
	(4, 'ιΨ', 2, '­', 1),
	(5, '΄', 2, 'kCΉ', 2),
	(6, 'gc', 2, '', 1),
	(7, 'Ι‘', 3, '­', 2),
	(8, 'R{', 3, '_ήμ', 3),
	(9, 'X{', 4, '«κ', 4),
	(10, 'gͺ', 4, '_ήμ', 5)
;

-- E studente[uυ - »Μ1
SELECT * FROM student WHERE grade = 1;

-- F studente[uυ - »Μ2
SELECT * FROM student WHERE hometown = '';

-- G majore[uυ
SELECT major_name FROM major;

-- H studente[uΜR[hXV
UPDATE student SET grade = 3 WHERE student_id = 10;

-- I studente[uΜR[hν
DELETE FROM student WHERE student_id = 10;





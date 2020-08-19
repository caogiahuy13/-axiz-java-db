-- �@ AND�����A���בւ�
SELECT * FROM student 
	WHERE grade = 1 AND hometown = '����'
	ORDER BY student_id;

-- �A OR�����ALIKE�w��A���בւ�
SELECT * FROM student
	WHERE grade = 1 OR student_name LIKE '%�{'
	ORDER BY student_id DESC;

-- �B GROUP BY�AMAX
SELECT major_id, MAX(grade) 
	FROM student
	GROUP BY major_id
	ORDER BY major_id;

-- �C GROUP BY�ACOUNT�AHAVING
SELECT hometown, COUNT(student_id) 
	FROM student
	GROUP BY hometown
	HAVING COUNT(student_id) >= 2
	ORDER BY hometown;

-- �D JOIN�A���בւ�
SELECT student_name, major_name 
	FROM student 
	JOIN major ON student.major_id = major.major_id
	ORDER BY major_name, student_name;

-- �E JOIN�A�����w��A���בւ�
SELECT student_id, student_name, hometown, major_name
	FROM student
	JOIN major ON student.major_id = major.major_id
	WHERE hometown <> '����'
	ORDER BY major_name, student_id;

-- �F �T�u�N�G�� - ����1
SELECT student_id, student_name, grade
	FROM student
	WHERE major_id = (
		SELECT major_id 
			FROM major 
			WHERE major_name = '�p���w'
	);

-- �G �T�u�N�G�� - ����2�AIN
SELECT student_id, student_name, major_id
	FROM student
	WHERE major_id IN (
		SELECT major_id
			FROM student
			GROUP BY major_id
			HAVING COUNT(student_id) >= 3
	)
	ORDER BY major_id;



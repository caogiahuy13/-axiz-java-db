-- ① AND条件、並べ替え
SELECT * FROM student 
	WHERE grade = 1 AND hometown = '東京'
	ORDER BY student_id;

-- ② OR条件、LIKE指定、並べ替え
SELECT * FROM student
	WHERE grade = 1 OR student_name LIKE '%本'
	ORDER BY student_id DESC;

-- ③ GROUP BY、MAX
SELECT major_id, MAX(grade) 
	FROM student
	GROUP BY major_id
	ORDER BY major_id;

-- ④ GROUP BY、COUNT、HAVING
SELECT hometown, COUNT(student_id) 
	FROM student
	GROUP BY hometown
	HAVING COUNT(student_id) >= 2
	ORDER BY hometown;

-- ⑤ JOIN、並べ替え
SELECT student_name, major_name 
	FROM student 
	JOIN major ON student.major_id = major.major_id
	ORDER BY major_name, student_name;

-- ⑥ JOIN、条件指定、並べ替え
SELECT student_id, student_name, hometown, major_name
	FROM student
	JOIN major ON student.major_id = major.major_id
	WHERE hometown <> '東京'
	ORDER BY major_name, student_id;

-- ⑦ サブクエリ - その1
SELECT student_id, student_name, grade
	FROM student
	WHERE major_id = (
		SELECT major_id 
			FROM major 
			WHERE major_name = '英文学'
	);

-- ⑧ サブクエリ - その2、IN
SELECT student_id, student_name, major_id
	FROM student
	WHERE major_id IN (
		SELECT major_id
			FROM student
			GROUP BY major_id
			HAVING COUNT(student_id) >= 3
	)
	ORDER BY major_id;



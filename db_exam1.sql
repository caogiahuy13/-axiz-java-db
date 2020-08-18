DROP DATABASE axizdb_exam;

-- �@ �f�[�^�x�[�X�쐬
CREATE DATABASE axizdb_exam;

-- �A �e�[�u���쐬 ? ����1 
CREATE TABLE major (
	major_id INT PRIMARY KEY,
	major_name VARCHAR(50)
);

-- �B �e�[�u���쐬 ? ����2
CREATE TABLE student (
	student_id INT PRIMARY KEY,
	student_name VARCHAR(50),
	grade INT,
	hometown VARCHAR(50),
	major_id INT NOT NULL REFERENCES major(major_id)
);

-- �C �gmajor�h�e�[�u���փf�[�^�o�^
INSERT INTO major (major_id, major_name) VALUES 
	(1, '�p���w'),
	(2, '���p���w'),
	(3, '���H�w'),
	(4, '�o�ϊw'),
	(5, '���ە���')
;

-- �D �gstudent�h�e�[�u���փf�[�^�o�^
INSERT INTO student (student_id, student_name, grade, hometown, major_id)
VALUES
	(1, '�R�c', 1, '�{��', 1),
	(2, '�c��', 1, '����', 2),
	(3, '����', 1, '����', 3),
	(4, '���', 2, '������', 1),
	(5, '����', 2, '�k�C��', 2),
	(6, '�g�c', 2, '����', 1),
	(7, '�ɓ�', 3, '������', 2),
	(8, '�R�{', 3, '�_�ސ�', 3),
	(9, '�X�{', 4, '����', 4),
	(10, '�g��', 4, '�_�ސ�', 5)
;

-- �E student�e�[�u������ - ����1
SELECT * FROM student WHERE grade = 1;

-- �F student�e�[�u������ - ����2
SELECT * FROM student WHERE hometown = '����';

-- �G major�e�[�u������
SELECT major_name FROM major;

-- �H student�e�[�u���̃��R�[�h�X�V
UPDATE student SET grade = 3 WHERE student_id = 10;

-- �I student�e�[�u���̃��R�[�h�폜
DELETE FROM student WHERE student_id = 10;





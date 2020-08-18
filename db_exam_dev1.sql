DROP DATABASE axizdb_exam_dev;

-- �@ �f�[�^�x�[�X�쐬
CREATE DATABASE axizdb_exam_dev;

-- �A �e�[�u���쐬 ? ����1 
CREATE TABLE customer (
	customer_id INT PRIMARY KEY,
	customer_name VARCHAR(50)
);

-- �B �e�[�u���쐬 ? ����2 
CREATE TABLE sales (
	sales_id INT PRIMARY KEY,
	order_date DATE,
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	amount DECIMAL
);

-- �C �gcustomer�h�e�[�u���փf�[�^�o�^
INSERT INTO customer (customer_id, customer_name) VALUES
	(1, '�c��'),
	(2, '���'),
	(3, '�c��'),
	(4, '�c��')
;

-- �D �gsales�h�e�[�u���փf�[�^�o�^
INSERT INTO sales (sales_id, order_date, customer_id, amount) VALUES
	(1, '2018-11-01', 1, 3000),
	(2, '2018-10-01', 3, 5000),
	(3, '2018-10-01', 4, 6000),
	(4, '2018-11-02', 2, 2000),
	(5, '2018-11-15', 2, NULL)
;

-- �E sales�e�[�u������ - ����1
SELECT * FROM sales WHERE amount < 5000;

-- �F sales�e�[�u������ - ����2
SELECT * FROM sales WHERE amount >= 5000;

-- �G sales�e�[�u������ - ����3
SELECT *, amount*1.1 FROM sales;

-- �H sales�e�[�u������ - ����4
SELECT * FROM sales WHERE amount IS NOT NULL;

-- �I customer�e�[�u������ - ����1
SELECT * FROM customer WHERE customer_name <> '�c��';

-- �J sales�e�[�u���̃��R�[�h�X�V
UPDATE sales SET order_date = '2018-11-05', customer_id = 4 WHERE sales_id = 4;

-- �K sales�e�[�u���̃��R�[�h�폜
DELETE FROM sales WHERE amount IS NULL;



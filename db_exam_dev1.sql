DROP DATABASE axizdb_exam_dev;

-- ① データベース作成
CREATE DATABASE axizdb_exam_dev;

-- ② テーブル作成 ? その1 
CREATE TABLE customer (
	customer_id INT PRIMARY KEY,
	customer_name VARCHAR(50)
);

-- ③ テーブル作成 ? その2 
CREATE TABLE sales (
	sales_id INT PRIMARY KEY,
	order_date DATE,
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	amount DECIMAL
);

-- ④ “customer”テーブルへデータ登録
INSERT INTO customer (customer_id, customer_name) VALUES
	(1, '田中'),
	(2, '鈴木'),
	(3, '田中'),
	(4, '田島')
;

-- ⑤ “sales”テーブルへデータ登録
INSERT INTO sales (sales_id, order_date, customer_id, amount) VALUES
	(1, '2018-11-01', 1, 3000),
	(2, '2018-10-01', 3, 5000),
	(3, '2018-10-01', 4, 6000),
	(4, '2018-11-02', 2, 2000),
	(5, '2018-11-15', 2, NULL)
;

-- ⑥ salesテーブル検索 - その1
SELECT * FROM sales WHERE amount < 5000;

-- ⑦ salesテーブル検索 - その2
SELECT * FROM sales WHERE amount >= 5000;

-- ⑧ salesテーブル検索 - その3
SELECT *, amount*1.1 FROM sales;

-- ⑨ salesテーブル検索 - その4
SELECT * FROM sales WHERE amount IS NOT NULL;

-- ⑩ customerテーブル検索 - その1
SELECT * FROM customer WHERE customer_name <> '田中';

-- ⑪ salesテーブルのレコード更新
UPDATE sales SET order_date = '2018-11-05', customer_id = 4 WHERE sales_id = 4;

-- ⑫ salesテーブルのレコード削除
DELETE FROM sales WHERE amount IS NULL;



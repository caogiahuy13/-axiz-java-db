CREATE TABLE customer (
	customer_id INT PRIMARY KEY,
	customer_name VARCHAR(50)
);

CREATE TABLE sales (
	sales_id INT PRIMARY KEY,
	order_date DATE,
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	amount DECIMAL
);

INSERT INTO customer (customer_id, customer_name) VALUES
	(1, '田中'),
	(2, '鈴木'),
	(3, '田中'),
	(4, '田島')
;

INSERT INTO sales (sales_id, order_date, customer_id, amount) VALUES
	(1, '2018/11/01', 1, 3000),
	(2, '2018/10/01', 3, 5000),
	(3, '2018/10/01', 4, 6000),
	(4, '2018/11/05', 4, 2000)
;

-- WHERE
SELECT * FROM customer WHERE customer_name = '田中';

-- AND/OR
SELECT * FROM customer 
	WHERE customer_id = 1
	AND customer_name = '田中';

SELECT * FROM customer 
	WHERE customer_id = 1
	OR customer_name = '鈴木';

-- LIKE
SELECT * FROM customer 
	WHERE customer_name LIKE '田%';

-- IN
SELECT * FROM customer 
	WHERE customer_id IN (1, 2);

-- BETWEEN
SELECT * FROM customer 
	WHERE customer_id BETWEEN 1 AND 10;

-- DISTINCT
SELECT DISTINCT customer_name FROM customer;

-- COUNT
SELECT COUNT(*) FROM customer WHERE customer_name = '田中';

-- SUM
SELECT SUM(amount) FROM sales;

-- MAX
SELECT MAX(amount) FROM sales;

-- MIN
SELECT MIN(amount) FROM sales;

-- AVG
SELECT AVG(amount) FROM sales;

-- GROUP BY
SELECT order_date, SUM(amount) 
	FROM sales
	GROUP BY order_date;

-- HAVING
SELECT order_date FROM sales 
	GROUP BY order_date
	HAVING SUM(amount) > 4000;

-- ORDER BY
SELECT * FROM sales ORDER BY customer_id;

-- AS
SELECT c.customer_id AS id, c.customer_name AS customer
	FROM customer AS c;

SELECT c.customer_id id, c.customer_name customer
	FROM customer c;

-- JOIN
SELECT order_date, customer_name
	FROM sales 
	JOIN customer ON sales.customer_id = customer_id;

-- サブクエリ
SELECT max_customer_id, order_date 
	FROM (
		SELECT MAX(customer_id) AS max_customer_id
		FROM customer
	) AS c
	JOIN sales ON max_customer_id = customer_id;

-- SQL文の例 - 1
SELECT order_date, COUNT(*) AS count, SUM(amount) AS sum_amount
	FROM sales
	WHERE order_date BETWEEN '2018/10/01' AND '2018/11/04'
	GROUP BY order_date
	HAVING COUNT(*) > 1;

-- SQL文の例 - 2
SELECT *
	FROM sales
	WHERE amount >= 5000
	OR customer_id = (SELECT MIN(customer_id) FROM customer)
	ORDER BY order_date, amount DESC







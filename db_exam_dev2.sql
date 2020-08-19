-- �@ CREATE
CREATE TABLE sales_old (
	sales_id INT PRIMARY KEY,
	order_date DATE,
	customer_id INT NOT NULL REFERENCES customer(customer_id),
	amount DECIMAL
);

-- �A INSERT
INSERT INTO sales_old (sales_id, order_date, customer_id, amount) VALUES
	(6, '2018/09/02', 2, 20000),
	(7, '2018/09/02', 1, 5000),
	(8, '2018/09/02', 3, 6000),
	(9, '2018/09/05', 1, 3000)
;

-- �B INSERT�ASELECT
INSERT INTO sales (SELECT * FROM sales_old);

-- �C DROP
DROP TABLE sales_old;

-- �D CASE WHEN�A�ʖ�
SELECT sales_id, order_date, 
	(CASE 
		WHEN order_date < '2018/10/01' THEN '�Z'
		ELSE '' 
		END
	) AS is_old
	FROM sales
	ORDER BY order_date;

-- �E �����񌋍��A�ʖ�
SELECT (customer_id || ':' || customer_name) AS customer_id_name
	FROM customer
	ORDER BY customer_id;

-- �F LIMIT
SELECT * FROM sales
	WHERE customer_id = 1
	ORDER BY order_date DESC
	LIMIT 2;

-- �G GROUP BY�AMIN�ASUM�A�T�u�N�G���A�ʖ�
SELECT order_date, SUM(amount) AS sum_amount
	FROM sales
	WHERE order_date = (
		SELECT MIN(order_date) FROM sales
	)
	GROUP BY order_date;

-- �H GROUP BY�AJOIN�A AVG�A TRUNC�A�ʖ�
SELECT customer.customer_id, customer_name, TRUNC(AVG(amount)) AS avg_amount
	FROM sales
	JOIN customer ON sales.customer_id = customer.customer_id
	GROUP BY customer.customer_id
	ORDER BY customer.customer_id;

-- �I BETWEEN�ALIMIT�A�T�u�N�G��
SELECT sales_id, order_date, customer_id, amount
	FROM sales
	WHERE sales_id = (
		SELECT sales_id
			FROM sales
			WHERE order_date BETWEEN '2018/09/01' AND '2018/09/30'
			ORDER BY amount DESC
			LIMIT 1
	);



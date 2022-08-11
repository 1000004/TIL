SELECT * FROM customers;
SELECT * FROM orderItems;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM vendors;

SELECT prod_name, prod_price FROM products WHERE vend_id IN('DLL01','BRS01') ORDER BY prod_name;
SELECT prod_name FROM products WHERE prod_price BETWEEN 5 AND 10;
SELECT prod_name FROM products WHERE prod_price IS NULL;
SELECT prod_name FROM products WHERE NOT vend_id = 'DLL01';
SELECT prod_id, prod_name FROM products WHERE prod_name LIKE 'Fish%'; 
SELECT prod_name FROM products WHERE prod_name LIKE 'F%y';
SELECT prod_id, quantity*item_price AS expanded_price FROM OrderItems WHERE order_num = 20008;
SELECT vend_id, COUNT(*) num_prods FROM products WHERE prod_price >= 4 GROUP BY vend_id HAVING COUNT(*) >= 2;
-- 집계함수 : 여러 레코드에 대한 연산 -> WHERE(X)
-- Ex) SUN(), MAX(), MIN(), AVG(), COUNT()

SELECT vend_id, SUM(prod_price) as total_price FROM products GROUP BY vend_id;

SELECT * FROM student;
-- 남학생 수, 여학생 수를 구하라
SELECT s_gender, COUNT(*) AS total_gender FROM student GROUP BY s_gender;
-- 남학생의 평균나이를 구하라.
SELECT AVG(s_age) FROM student WHERE s_gender='f';
-- 학급별 나이의 총합을 구하라.
SELECT s_class, SUM(s_age) as total age FROM student GROUP BY s_class;

SELECT * FROM customers;
SELECT * FROM orderItems;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM vendors;

-- sub-query 와 JOIN
SELECT * FROM products WHERE prod_name = 'King doll';
SELECT vend_id
	FROM products
	WHERE prod_name = "King doll";
-- sub-query
-- 유일한 값으로 보장하지 않는다
-- (p.k(null 불가능), 유니크(중복이 아닌 열 null 가능)로 찾는 경우 유일 값)
-- = 는 1대1인 경우  연산 가능(= 대신 IN을 사용 vend_id가 여러개 or)
SELECT vend_name, vend_address
	FROM vendors
	WHERE vend_id IN (SELECT vend_id
							FROM products
							WHERE prod_name = 'King doll');
SELECT vend_name, vend_address
FROM
	vendors, products
WHERE
 vendors.vend_id = products.vend_id
 AND
 prod_name = 'King doll';
SELECT vend_name, vend_address
FROM
 	vendors INNER JOIN products
ON
 	vendors.vend_id = products.vend_id
WHERE
 	prod_name='King doll';
SELECT vend_name, vend_address
FROM
	vendors NATURAL JOIN products
WHERE
	prod_name='King doll'
-- 결합 조건이 없다
-- NATURAL JOIN 외래키, 주키의 열 이름이 동일하는 경우 결합 조건 생략 가능

SELECT DISTINCT cust_name
FROM
	customers NATURAL JOIN orders NATURAL JOIN
	orderitems NATURAL JOIN products NATURAL JOIN
	vendors
WHERE
	vend_name = 'Bears R Us';
	
SELECT DISTINCT cust_name
FROM
	customers INNER JOIN orders INNER JOIN
	orderitems INNER JOIN products INNER JOIN
	vendors
WHERE
	vend_name = 'Bears R Us';
	
SELECT cust_name, item_price COUNT(order_num) AS quantitly
FROM customers NATURAL JOIN orders NATURAL JOIN orderitems
WHERE item_price = (SELECT MAX(item_price) 
							FROM orderitems);
							
SELECT vend_name
FROM vendors LEFT OUTER JOIN products
ON vendors.vend_id = products.vend_id
WHERE prod_name IS NULL;

SELECT * FROM customers;
SELECT * FROM orderItems;
SELECT * FROM orders;
SELECT * FROM products;
SELECT * FROM vendors;

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

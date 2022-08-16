CREATE TABLE emp (
	e_id			INT			PRIMARY KEY AUTO_INCREMENT,
	e_name		CHAR(20)		NOT NULL,
	manager_id	INT
);
DROP TABLE emp;
INSERT INTO emp (e_name, manager_id)
	VALUES
		('a', NULL),
		('b', 1),
		('c', 2),
		('d', 3),
		('e', 4);
		
SELECT * FROM emp;
-- self-join : 물리적으로 1개의 테이블을 논리적으로 2개 나누어 조인
-- 각 직원의 이름과 메니저 이름을 구하라.
SELECT e1.e_name employee, e2.e_name manager
	FROM emp e1 INNER JOIN emp e2
	ON e1.manager_id = e2.e_id;
	
SELECT e1.e_name employee, e2.e_name manager
	FROM emp e1 LEFT OUTER JOIN emp e2
	ON e1.manager_id=e2.e_id
	WHERE e2.e_id IS NULL;
-- self join은 cross join, inner join, outer join과 유형이 다르다

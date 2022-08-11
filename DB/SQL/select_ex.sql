CREATE TABLE myTable(
	-- <AUTO_INCREMENT>
	-- 테이블당 1개만 사용할 수 있다
	-- P.K일때만 사용가능하다.
	-- my-sql에만 존재한다.
	num		INT			PRIMARY KEY 	AUTO_INCREMENT,
	my_value CHAR(10)
);

INSERT INTO mytable (my_value) VALUE('first');
INSERT INTO mytable (my_value) VALUE('second');
INSERT INTO mytable (my_value) VALUE('third');
INSERT INTO mytable (my_value) VALUE('fourth');

SELECT * FROM myTable;

UPDATE myTable SET my_value = NULL WHERE num=8;

-- NULL 찾을때  =을 사용하면 안된다. IS를 쓴다.
-- NULL 찾기
SELECT * FROM mytable WHERE my_value IS NULL;
-- NULL 아닌거 찾기
SELECT * FROM mytable WHERE my_value IS NOT NULL;

-- 일반 주정 조건(NOT)
SELECT * FROM mytable WHERE NOT my_value = "first";

-- <집계함수> : count, max, min, sum, arg
-- 주키 갯수 = 레코드 갯수
SELECT COUNT(num) FROM mytable;
SELECT COUNT(*) FROM mytable;
-- NULL 갯수에서 제외된다.
SELECT COUNT(my_value) FROM mytable;
-- 직계함수는 스칼라 값을 가진다
-- rs.getInt(indx) or rs.getInt(열 이름) 
-- 열로 가져오는  경우 무엇을 꺼내는지 알기 어려우나성능은 좋다
-- 스칼라 값을 꺼내오는 경우 무조간 1이다

/*
	1. 최소 나이를 구한다.
	2. 1의 결과와 비교한다.
*/
-- SELECT : sub-query, join 중요
-- sub-query
-- 스칼라값이어야 한다(돌려주는 값이 하나)
SELECT s_name FROM student WHERE s_age = (SELECT MAX(s_age) FROM student);

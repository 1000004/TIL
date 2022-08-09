-- 드레그 선탞 후 -> 실행 ctrl F9
-- 드레그 선탞 후 -> 전체 실행 F9
SHOW DATABASES;
SHOW TABLES;

/*
	SQL에서는 대소문자 구분이 없다
	키워드 : 대문자
	이름,값 : 소문자
*/
-- 테이블 없애기
DROP TABLE student;

-- 테이블 만들기
CREATE TABLE student(
	s_id			CHAR(10)		PRIMARY KEY,
	s_name		VARCHAR(20)	NOT NULL,
	s_age			INT			NOT NULL,
	s_class		CHAR(1)		NOT NULL,
	s_gender		CHAR(1)		NOT NULL
);
-- 남 : m, 여자 : f
-- 테이블 스키마
DESC student;

-- 값입력(C)
INSERT INTO student (s_id, s_name, s_age, s_class, s_gender)
	VALUES ('s0001', 'jane', 22, 'a', 'f');
INSERT INTO student (s_name, s_id, s_class, s_age, s_gender)
	VALUES ('john', 's0003', 'a', 20, 'm');
-- 모든 열의 값을 다 입력할 경우
-- 열의 순서를 모두 알고 있는 경우
INSERT INTO student VALUES ('s0002', 'james', 23, 'b', 'm');

-- 다음을 입력하시오
--이름 : bob, 학번 : s0004, 나이 : 30, 성별 : 남자, 학급 : b
--이름 : sera, 학번 : s0005, 나이 : 21, 성별 : 여자, 학급 : a
--이름 : aliee, 학번 : s0006, 나이 : 20, 성별 : 여자, 학급 : b
--이름 : iu, 학번 : s0007, 나이 : 24, 성별 : 여자, 학급 : a
INSERT INTO student (s_name, s_id, s_age, s_gender, s_class)
	VALUES ('bob', 's0004', '30', 'm', 'b');
INSERT INTO student (s_name, s_id, s_age, s_gender, s_class)
	VALUES 	('sera', 's0005', '21', 'f', 'a'),
				('aliee', 's0006', '20', 'f', 'b'),
				('iu', 's0007', '24', 'f', 'a');
-- 읽기(R)
SELECT s_name FROM student;
SELECT s_name, s_age FROM student;
SELECT * FROM student;
-- alias 사용 (임시 별칭사용)
SELECT s_name student_name FROM student;
SELECT s_name AS student_name FROM student;

-- 조건절(WHERE)
-- 나이가 22살 보다 많은 학생의 이름과 나이를 구하라
SELECT s_name, s_age FROM student WHERE s_age > 22;

-- a반 삭생의 이름과 학번, 성별을 구하라.
-- '=' 는 대입이 아니라 같다는 의미
SELECT s_id, s_name, s_gender FROM student WHERE s_class = 'a';

-- b반이 아닌 학생의 이름과 학번과 성별을 구하라.
-- '<>' 는 아니다라는 의미 NOT s_class = 'b'로 쓸 수도 있다.
SELECT s_id, s_name, s_gender FROM student WHERE s_class <> 'b';

-- a반 학생 중 여학생의 학번, 이름, 나이를 구하라.
SELECT s_id, s_name, s_age FROM student WHERE s_class = 'a' AND s_gender = 'f';

-- 학생중 나이가 24살 이상, 30살 이하인 학생의 학번과 이름을 구하라.
SELECT s_id, s_name FROM student WHERE s_age >= 24 && s_age <= 30;
SELECT s_id, s_name FROM student WHERE s_age BETWEEN 24 AND 30;

-- 학생중 이름이 'james'이거나 'jane' 이거나 'iu'인 학생의 이름과 학급을 구하라.
SELECT s_name, s_class FROM student 
	WHERE s_name = 'james' OR s_name = 'jane' OR s_name = 'iu';

SELECT 
	s_name, s_class
FROM
	student
WHERE
	s_name IN ('james', 'jane', 'iu');
	
-- 학생중 나이가 20살이상 24살 이하인 여학생중 'a'반 학생의 이름을 구하라.
-- 조건절 표현 중 AND, OR이 함께 나오는 경우 우선 순위가 AND가 높다
-- 우선 순위 표형은 ()로 하자.
SELECT
	s_name
FROM
	student
WHERE
	s_age BETWEEN 20 AND 24 AND
	s_gender = 'f' AND
	s_class = 'a';
	
-- 정렬
SELECT * FROM student ORDER BY s_age;
SELECT * FROM student ORDER BY s_age DESC;

-- 나이로 오름차순 정렬.단, 나이가 같은 경우에는 학급으로 내림차순
-- LIMIT는 페이징을 구현할때 사용
SELECT * FROM student ORDER BY s_age ASC, class DESC;
SELECT * FROM student ORDER BY s_age ASC, class DESC LIMIT 5;
-- 3 -> indx 번호 indx 3번 부터 2개 보여준다
SELECT * FROM student ORDER BY s_age ASC, class DESC LIMIT 3, 2;
-- OFFSET 건너뛰기
SELECT * FROM student ORDER BY s_age ASC, class DESC LIMIT 2 OFFSET 3;

-- j로 이름이 시작하는 사람의 이름과 나이를 구하라.
-- % : 0 ~ 무한대 -> 'd%p'  : 'dp', 'daaaap', 'dangosfqp'
-- _ : 글자 1개 -> 'd_p' : 'dp'(x), 'dap'(o), 'dangosfqp'(x)
--							'a___e' : 글자수는 5글자, a로 시작해서 e로 끝난다.
SELECT
	s_name, s_age
FROM
	student
WHERE
	s_name LIKE 'j%';
	
SELECT
	s_name, s_age
FROM
	student
WHERE
	s_name LIKE 'j___';
	
--이름에 e가 들어가는 사람
SELECT
	s_name, s_age
FROM
	student
WHERE
	s_name LIKE '%e%';

-- 중복 소거
SELECT DISTINCT s_class FROM student;

-- 삭제(D)
-- student 안에 있는 데이터가 다 지워진다
DELETE FROM student;
-- 삭제/업데이트 하고자 하는 데이터가 맞는지 where 조건문을  select으로 확인 후 삭제
DELETE FROM student WHERE s_id = 's0001';
SELECT * FROM student WHERE s_id = 's0001';

-- 수정(U)
-- 한명만 지칭하고자 하는 경우 P.K를 사용
UPDATE student SET s_age = 40 WHERE s_id = 's0003';

* mysql 설정
* 명령 프롬프트
  * netstat -ano 사용중인 port 번호와 PID를 확인
* show databases; (존재하는 DB 확인)
* information_schema,mysql,performance_schema(MySQL 동작시 필요)(3개는 건들이면 안된다)
* mysql> use test;
* Database changed
* mysql> show tables;
* Empty set (0.00 sec) 테이블이 비어있다
* 이클립스에서 mysal 사용시 연결되어 있어야 한다
	* Data Source Explorer에서 연결
 ```SQL
 --- 이클립스에서 실행시 드레그 후 alt + x;
SHOW TABLES;
```
* heidisql 환경에서 MySQL 사용
 	* heidisql와 같은 프로그램을 클라이언트 프로그램이라고 한다
	* 기존 MySQL의 text 기반이 아닌 하이디는 GUI로 보여준다
```SQL
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

-- 테이블 스키마
DESC student;
```
* NOT NULL - 도매인 무결성
* INT(10) (제로필 설정)
 * 숫자는 바이트를 표현하는 것이 아니라 자리수가 남으면 0으로 체우겠다
 * int는 범위가 정해져 있으므로 정수 범위를 나타내는게 아니다
* chat(10)에서 10은 byte 수 표현
* **chat vs varchat**
	* CHAR
	 	* 빈칸을 유지
		* 공간낭비가 생길 수 있지만 수정에 유리 (단편화에 취약)(고정길이)
		* 변경이 잦은 경우 사용
	* VARCHAR
 		* 빈칸이 남으면 없앤다 (설정한 길이 3을 넘어가면 error)
 		* DB에 입력시 최종적으로 file에 저장됨 VARCHAR의 데이터 변경이 일어나면('ab'->'abc') 시프팅이 일어난다
 		* 공간 절약의 장점을 가지지만 수정에 취약하다 (단편화에 강하다)(가변길이)
 		* 길이는 알 수 없으나 한번정해지면 변경이 자주 일어나지 않는다 ex ) 이름

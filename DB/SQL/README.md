### [CREATE/SELECT](https://github.com/yeRim650/TIL/blob/main/DB/SQL/select_ex.sql)   
  ㄴ AUTO_INCREMENT
### [집계함수](https://github.com/yeRim650/TIL/blob/main/DB/SQL/aggregate_function.sql)
### [JOIN](https://github.com/yeRim650/TIL/blob/main/DB/SQL/join.sql)
  * 복수개 테이블을 JOIN으로 어떻게 합치는가에 따라 3가지로 나뉜다
   * INNER JOIN, OUTER JOIN, CROSS JOIN
   * INNER RIGHT - 합집합
   * LEFT/RIGHT OUTHER JOIN
    * left table OUTER JOIN right tabel
    * LEFT/RIGHT OUTHER JOIN인가에 따른 두 테이블에 존재하지 않더라도 테이블에 포함된다  
    (ex LEFT OUTER JOIN울 하면 left 테이블 데이터가 다 표함되며 right 테이블에 없으면 NULL로 포함된다)  
    (customers LEFT OUTER JOIN orders 와 oders RIGHT OUTER JOIN cusomers 는 같은 표현 이다)
   * CROSS JOIN은 연산의 목적이 아닌 성능 테스트를 목적으로 사용
   * **물리적 분할 되어 있는 table을 논리적으로 합치기 위해 Join을 사용**  
  (역정규화 발생 - 3차 정규화에 어긋나는 이행적 함수 종속이 발생될 가능성 있있다)
```SQL
SELECT *
FROM 테이블1 JOIN 테이블2
ON 레코드 결합 조건
```
* 레코드 결합 조건은 열 이름이 같으면 테이블 이름을 붙여야 한다 (ex vendors.vend_id = products.vent_id)
* 테이블 이름이 길면 별칭으로 테이블 접근 할 수 있다 FORM에서 테이블 AS 별칭 으로 준다
* 직관성과 NATURAL JOIN으로 사용하기 위해  열이름을 똑같이 만드는 것이 좋다
* 몇개의 테이블을 조인할 수 있는지가 중요하것이 아니라 복잡한 다수의 테이블 데이터를 관계를 이용할 수 있는가가 중요 
* 즉, **테이블 관계 팍악 중요** : 테이블 관계를 파악 할 수 있는 E.R 다이어그램(ERD)(Entity)
### 쿼리 만들기
* 쿼리(Query)란 데이터베이스나 파일의 내용 중 원하는 내용을 검색하기 위하여 몇 개의 코드(code)나 키(Key)를 기초로 질의하는 것을 말한다.
* 데이터베이스에게 특정한 데이터를 보여달라는 클라이언트(사용자)의 요청

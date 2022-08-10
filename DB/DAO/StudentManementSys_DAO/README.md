### DAOFactory
* Class.forName(풀패키지 명) 객체를 만들어내는 메서드
#### Reflection
* 클래스 정보를 가지고 객체를 만들어내는 기술 , 풀패키지 명만 있으면 풀패키지 명이 나타내는 클래스를 만들어낸다  
(일반적인 코드를 만들때 쓰는게 아닌 일반적으로 useBean 사용되는 기술)  
(눈에 보이는 코드를 만들때 만드는 기술이 아닌 프로그램을 동작시키는 기반을 만들어낼 때 사용)  
(프레임 워크에서 직접 객체를 만들지 않아도 알아서 생성시 사용된는 기술)  
(private한 멤버변수 메소드 생성자도 reflection을 통해 접근이 가능해 지는 위험이 있다)  
(객체 지향의 특징인 캡슐화를 무력화 시킬 수 있다)  
* Class 객체를 이용하면 객체 지향의 접근제한자의 역활이 무시될 수 있다
### TDD
* JUnit (단위테스트) 하나의 기능(메서드)를 만들고 나면 제대로 동작하는지 테스트를 지원한다
* 오류나 생각지도 못한 상황을 원천적으로 막을 수 있다
* XP(eXtreme Programming) 실용성을 최대한 끌어올린 개발 방법 중 하나
  * XP에서 제시한 테스트 주도 개발 방식 **TDD**
  * **짝프로그래밍** 버그와 오류를 줄일 수 있다
### JUnit
```java
@BeforClass
전체테스트 수행전 1번만 실행
@After Class
전체테스트 수행후 1번 실행
@Before
매테스트 수행전 실행
@After
매테스트 스행후 실행
@Test
실제 태스트 기능

```
### transaction
* 더이상 쪼개질 수 없는 일 다위
* A -> B -> C  전부 선공해야 비로서 처리(commit) 하나라도 실패하면 rollBack()
* 게시글을 선택 했을때 조회수 증가(dao.update()) 후 글가져오는 기능을 수행할 때 (dao.select())
  * setAutoCommit(true)시 각각 commit
  * setAutoCommit(false)시 두가지 작업이 성공여부를 확인 후 if문을 통해 rollBack과 commit을 할 수 있다. (허가시 적용 가능)
* setAutoCommit(true) : DB에 자동으로 반영 시키는걸 자동 commit이라고 한다
* setAutoCommit(false) : 강제 커밋할때 까지 반영(cpmmit)되지 않는다

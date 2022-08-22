### Spring
* Spring 자바의 framework 중 하나
* Spring MVC는 Spring의 섹터중 하나 MVC로 관리할 수 있게 만들어 준다
* Spring의 이점 중 하나로 어노테이션을 기반으로 동작
  * 동일한 기능을 수행하는 클레스를 만들어 낼때 규칙(인터페이스)를 만들어 정해진 형태로만 메서드를 만들 수 있었다면
  * Spring에서는 클래스가 상속 받거나 구현 하는 것 없이 어노테이션을 기반으로 역할이 결정된다 메서드 이름이나 리턴이나 파라미터 사용이 자유롭다
  * **이러한 것을 포조라고 한다**
* 포조 (Plain Old Java Object, POJO) - 기본적인 자바 클래스 상속받거나 구하는 것이 아닌 제한이 없이  있는 객체
* Spring은 포조를 기반으로 동작한다(어노테이션을 이용해 자유를 구현)
#### framework vs library
* IoC(Inversion of Control) 패턴 제어의 역전
	* 제어 흐름에 대한 주도권이 누구에게 있느냐?
* library는 기능을 제공해주고 어떻게 상용할지는 개발자가 결정
* framework는 기능을 제공할때 사용하는데 규칙, 룰, 순서로 코드를 작성하면 기능을 알아서 수행
* **프로그래밍의 제어, 코드 흐름 제어를 framework에서 결정**  
ex Spring MVC는 정해진 규칙대로 코드를 작성해 주면 알아서 MVC 구조로 만들어준다
* 제공하는 기능의 목적은 정해져 있으며 주도권을 사람이 아닌 framework이 가진다
* 지적된 룰 대로만 만들어주면 정해진 동작 방식 대로 만들어준다(어떻게 동작이 구현되는지는 몰라도 된다)
#### Spring이 제공하는 MVC, D.I, JDBC를 중접으로 배움 (이 밖에도 제공하는 섹터는 많다)
* JSP, Servlet, Cmd, Dao의 각 계층별 framwork가 있다
(JSP, Servlet, Service, Depository(DAO))
* Spring MVC는 JSP, Servlet, Cmd간의 흐름을 연결해준다
* D.I 전반적으로 사용
* JDBC는 Depository에 사용
* DAO에서 주로 사용하는 framework
  * My-Batis
  * Hibernate
  * Spring-JDBC
  * 궁극적인 목적은 같다 DAO 코드를 줄이고 SQL문을 밖으로 빼준다
  * (framework마다 설정이 다르다)
### Spring MVC
* **sts 확경**
* 스프링이 서브릿 제공 - org.springframework.web.servlet.DispatcherServlet
* top-level package 이름이 root이름이 된다  
ex org.green.first -> http://localhost:8080/first/
* project의 properties를 통해 web Prroject Settings로 context root 변경이 가능하다
* servlet 위치는 xml로 경로 경 가능하다  
(context-param tag를 통해 application 전체에서 사용 가능한 설정 파일을 root로 지정)  
(servlet tag 내부에 init-param tag로 서블릿 내부에서만 사용 가능한 설정 파일을 root로 지정)  
* 파일 위치는 수정이 가능하다
#### Spring MVC Flow
![Spring_MVC_Flow](https://user-images.githubusercontent.com/102463200/185099684-bdb0cdfe-a84a-449f-b96d-1f5b059babc4.png)  
* HandlerMapping, DispatcherServlet, ViewResolver은 Spring에서 제공해 주며
* Controller, View만 작업하면 된다
* 요청에 대응하는 Controller와 View만 만들면 나머지는 Spring에서 제공해주므로 알아서 동작한다.
#### HandlerMapping와 Controller
* URL과 매핑된는 컨트롤러를 HandlerMapping이 어떻게 찾는가?
  * 래스 명 위에 @Controller가 붙으면 HandlerMapping이 controller를 찾는 대상이 된다
```java
@RequestMapping(value = {"/","/goHello"}, method = RequestMethod.GET)
public String home() {}
```
* root로 들어온 경우 실행할 method 지정
* HandlerMapping은 요청(URL)이 들어오면 해당하는 요청을 처리하는 Controller의 method를 찾는다
#### ResourceViewResolver가 하는 일
* org.springframework.web.servlet.view.InternalResourceViewResolver (spring에서 제공)
* name="prefix" value="/WEB-INF/views/" 는 controller 메서드가 리턴한 String에 앞에 붙는다
* name="suffix" value=".jsp"는 controller 매서드가 리턴한 String에 앞에 붙는다
* **ViewResolver가 하는 일은 controller 매서드가 리턴한 값에 앞에 prefix로 설정한 값을 붙이고 뒤에 suffix로 설정한 값을 붙인다**  
-> **경로가 된다**  
ex /WEB-INF/views/home.jsp
* 참고
  * WEB-INF 에 존재하는 jsp는 외부에서 요청이 불가 forward만 가능 (클라이언트가 요청 불가 위치)
#### Spring bean
* 컨트롤러를 찾을때 대상이 되는 것을 Spring에서는 bean이 된다 (bean이 아니면 검색 대상이 되지 않는다)  
* bean이란? 스프링이 인지하고 있는 관리하고 있는 클래스  
* 클래스에 s가 붙어있으면 bean에서 관리하고 있는 클래스임을 알 수 있다
* STS(Spring Tool Suite)상에서 j에 s배지가 붙어 있으면 bean이다
```java
 bean으로 등록하는 어노테이션
 @Component : bean으로 등록하는 이노테이션 (대빵 밑에 어노테이션은 @Component 상속)
 @Controller : Controller 역할을 수행
 @Service : Cmd 클래스 역할 수행
 @Repository : DAO역할  수행
```
#### 어노테이션
```xml
<annotation-driven />
```
* 해당 tag 없으면 어노테이션이 역활 못한다
```xml
<context:component-scan base-package="org.green.first" />
```
* 어노테이션을 붙여다고 해서 무조건 bean이 되는 것이 아닌 다음과 같이 약속된 페키지 내에서만 bean으로 등록된다
#### Controller 
* 하나의 URL에 처리하는 메서드를 하나만만 들어야 에러가 뜨지 않는다 
* ModelAndVeiw = Model(requset 의 attribute) + View(jsp)
* Model model - request 속성
#### maven
* library나 개발 할때 필요한 환경 같은걸 자동으로 구축해준다(형상관리 framework )
* maven과 비슷한 기능을 하는 framework가 많지만 sts는 Spring legacy Project에서 기본적으로 maven을 지원한다
* pom.xml 파일에 사용할 라이블러리 추가
* 실제 라이블러리 위치
  * C:\.m2\repository\mysql\mysql-connector-java\5.1.35
```xml
<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>5.1.35</version>
</dependency>
```
#### Encoding
![image](https://user-images.githubusercontent.com/102463200/185103233-9c9f0387-7bb8-41db-a40b-ac695043f025.png)
* CharacterEncodingFilter를 Spring에서 제공

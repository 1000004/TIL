### **웹** : 인터넷(네트워크 망 이름)에서 제공되는 서비스
* 프로그램이 가지는 4가지 속성 **CRUD**(Creat Read Update Delete)
* 기능, 구조(MVC)를 구현
* 게시판 만들기
  * CRUD를 잘 나타내는 프로그램
  * 웹상에서 흔하게 볼 수 있는 프로그램
* Framwork (java framwork - Spring)
* js, database(SQL), JSP/Servlet, Spring
* 웹 사이트를 만들 때 사용하는 기술
  * 개발 언어: 자바
  * 웹/어플리케이션 서버 : HTTPD(아파치 웹 서버)나 NGINX, **톰캣**, 웹로직 등
  * **서버 웹 기술** : **JSP, 서블릿**(서버에서 연산,클라이언트에서 확인 불가능)
  * 서버 웹 기술을 위한 프레임 워크 : **스프링 MVC**
  * **클라이언트 웹 기술** : HTML, 자바 스크립트(클라이언트에서 연산,코드 확인 가능)
  * 클라이언트 웹 기술을 위한 프레임워크나 라이브러리 : jQuery, 앵귤러JS, Node.js 등 (둘다 자바스크립트 라이브러리)
  * 데이터베이스 연동 : JDBC(자바로 만든 프로그램과 데이터 베이스 연결 기술), MyBotis(프레임 워크), JPA(프레임 워크)
  * DBMS : **MySQL**, MS SQL, 오라클, DB2
  * 통신 프로토콜 : HTTP
  * OS : 센트OS, 윈도우 서버 2012 등
* 웹 사이트를 만들기 위해서는 서버 웹 기술, 클라이언트 웹 기술, 데이터베이스 연동
  * JSP를 이용한 웹 사이트 개발
  * 서버 코드의 전형적인 구조(서비스-DAO, DTO 구성)
  * 서블릿에 대한 기초
  * MVC 구조에 대한 기초
  * JSP와 DB를 연동한 게시판 개발
* HTML, JS (클라이언트 언어) 표준이 있지만 브라우저에서 해석이 다르다
* 사용자의 브라우저, 브라우저 버전을 알 수 없다 -> 브라우저와 관계없이 똑같이 동작하고 똑같이 보여주는 **Cross Browsing**
* 데이터 베이스 SQL에도 표준이 있지만 데이터 베이스 브랜드에 따라 다르다
* **표준을 잘 알아야 한다** 표준을 바탕으로 다른점을 안다
* URL(Uniform Resource Locator) : 위치기반으로 자원을 구분
* URI : 자원을 구별하는 식별자
* URL을 입력하면 브라우저에서 서버로 요청이 갔다
> https://book.naver.com/bookdb/book_detail.naver?bid=22502844  
> https 프로토콜    
> book.naver.com 서버 이름  
> bookdb/book_detail.naver 경로  
> bid=22502844 질의 표시된 경로로 해당 값를 전달  
* 똑같은 경로의 페이지 디자인 HTML, JS
* 값만 변경 code에 따른 변경
* 보여주는 일을 하는 클라이언트, 채우는 값은 서버(JSP/Servlet)에서 가져온다
* 서버 이름 끝에 붙이는 포트 번호 생략 기본 :80
* 서버 이름는 DNS를 거처서 IP로 변경
* 웹 서버에 웹페이지를 달라고 하는 것을 요청(requset)
* 요청한 웹 페이지를 웹 브라우저에 제공하는 것을 응답(response)
* 클라이언트(네트워크 프로그램에서 요청하는), 서버(요청을 받아 알맞은 기능이나 데이터를 제공하는) 
* 서버 컴퓨터는 가정에서 사용하는 컴퓨터보다 안전성을 제공
* localhost 내 컴퓨터 IP를 나타내는 도메인
* 8080 tompcate 기본 포트
* HTTP(프로토콜) - W3C 웹 표준을 정의한 단체
#### 정적 자원과 동적 자원
* 정적 자원 - 고정된 결과를 출력되는 자원
* 동적 자원 - 시간이나 특정 조건에 따라 응답 데이터가 달라지는 자원(연산이 필요하다)
* JSP를 비롯해서 PHP, ASP.net 등 많은 웹 관련 기술들이 바로 동적 페이즈를 만드는데 사용되는 프로그래밍 기술
* 서버 사이드 스크립트 언어(server-side script) : 서버 사이드에서 실행되는 스크립트 언어(JSP 등)
#### 웹 프로그래밍과 JSP
* 웹 프로그램밍을 하기 위해서는 네트워크 처리, HTTP 헤더, 파일 입출력 처리 등에 대해서 알아야 할 필요는 없다 하지만 인과관계를 알아야 변화에 취약해지지 않을 수 있다
* JSP(JavaServer Pages) 동적 페이지를 작성하는데 사용되는 자바의 표준 기술
  * **HTML 응답을 생성하는 목적으로 JSP 사용**
  * 페이지는 동적으로 변경된다
* JSP을 이용해서 만든 프로그램을 실행하려면 Apache tomcat(아파치 톰켓), Jetty(제티), JBoss EAP와 같은 서버 프로그램이 필요
  * 이러한 서버 프로그램을 **WAS(Web Application Server)**
* **WAS**
  * JSP/Java 동작 환경을 만들어준다
  * 단순 웹 서버는 정적 HTML 파일이나 이미지를 제공하는 것과 달리 어플리케이션을 구현하는데 필요한 기능을 제공
  * 클라이언트의 요청이 오면, 알맞는 프로그램을 실행해서 응답을 생성
<img src="https://postfiles.pstatic.net/MjAyMjA3MTRfMjEy/MDAxNjU3Nzg4MzQ2MDUw.jy46dFfWHTwgKoJ-igWRjlVj44N3X5WQDBthOfjZulkg.hJY117iB1T8n8XTgIuJ20EYslXEhlxtZKlbksta6lEYg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
  * was가 JSP로 만들어진 프로그램에 request 객체를 만들어 주면 프로그램은 respons 객체를 결과로 준다

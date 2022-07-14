### JSP
* Servlet:java web → JSP:java보다 간단한 문법 사용
* Servlet이 먼저 나왔기때문에 버전이 앞서있다(맞는 버전이 있다)
* 표현 하는 방법에 차이
* 브라우저에 html를 바로 띄우지 않고 컴퓨터는 한개이지만 논리적으로 tomcat서버를 만들고 크롬이 tomcat에 요청을 하면 time.jsp를 실행하고 결과를 HTML,CSS,JS 표현와 함께 reponse body에 담아 전송
* 브라우저는 전달 받은 HTML 문서를 렌더링하여 보여준다
<img src="https://postfiles.pstatic.net/MjAyMjA3MTRfMjUy/MDAxNjU3NzkyNDc3MTQ4.wxVDmikys06sRCTHXrsiWPsMVFiW6_bGXATFwtXiFv0g.oKK1T129zJB3h2NFR0KqIOBMNyJBda_cr87zMVdxb8Eg.PNG.forget980/image.png?type=w580" width="60%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>현재시간</title>
</head>
<body>
지금 : <%= new java.util.Date() %>
</body>
</html>
```
* 페이지 소스
```HTML
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>현재시간</title>
</head>
<body>
지금 : Thu Jul 14 18:42:10 KST 2022
</body>
</html>
```
* JSP는 서버에서 실행된 상태로 넘어갔다 (JSP 표현은 동적 데이터 / HTML, JS, CSS 표현은 정적 데이터 )
* Server 실행 JSP
* Client 실행 HTML, JS, CSS
* http://localhost:8080/07_14/time.jsp
    * localhost 도메인 가상 IP : 127.0. 0.1
    * 8080 톰켓 port (프로세스 식별자)
    * 07_14/time.jsp (경로)
* 에러
    * 에러 404 : page not found ex 잘못된 url 요청
        * 4xx:클라이언 요청 문제
    * 에러 500 : ex 예외 발생
        * 5xx:서버 문제 
        * 에러가 발생하면 콘솔을 확인한다
    * 정상 수행 200 
#### JSP 페이지의 구성 요소
* 디렉티브(Directive) <%@...%>
* 스크립트 : 스크립트릿 <%...%>, 표현식 <%=...%>, 선언부 <%!...%>
* 표현 언어(E.L)
* 정적인 데이터(HTML, JS, CSS)
* 표준 액션 태그
* 커스텀 태그와 표준 태그 라이브러리
##### 디렉티브
* 설정(기능 수행x)
* <%@ page contentType = "tex/html; charset=utf-8" %>
* tex/html → mine type
* text기반 구성된 정보이고 문서 구조는 html을 따라간다
* charset=utf-8 → utf-8로 읽어라
* pageEncoding="EUC-KR" 페이지를 작성할때 인코딩(이클립스의 인코딩)
* JSP가 제공하는 디렉티브
    * page
    * taglib
    * include
##### 스크립트 요소
* 표현식
* 스크립트릿
* 선언부
##### 기본 객체
* request, response, session, application, page
#### page 다이렉티브
* <%@...%>
* **contentType**
* MIME(Multipurpose Internet Mail Extensions) HTTP등의 프로토콜에서도 응답 데이터의 내용을 설명하기 위해 사용 (기본 값 text/html)
* **ISO-8859-1 vs EUC-KR vs UTF-8**
    * contentType 속성의 charset 기본값 : ISO-8859-1
    * EUC-KR : 영어+한글
    * UTF-8 : 다국어
    * UTF-8는 다국어를 표현 할 수 있어 좋지만 글자를 표현하는데 많은 바이트가 필요하다
* 인코딩 종류
    * 브라우저 인코딩
    * WAS 인코딩(개발툴 JSP/Servlet)
    * DB 인코딩 (데이터베이스 인코딩 변경 불가 코드로 인코딩 변경)
    * 사용하는 브라우저, WAS 인코딩이 하나라도 안맞으면 글자는 깨진다
* **import**
> <%@ page import = "java.util.Calendar" %>  
> <%@ page import = "java.util.Date" %> ->( 권장 )

> <%@ page import = "java.util.Calender,java.util.Date" %> ->( x )

> <%@ page import = "java.util.*" %>
```HTML
<%
    java.util.Calendar cal = java.util.Calendar.getInstance();
%>
```
* full package명으로 이용 가능
* trimDirectiveWhitespaces 공백 처리 가능
    * <%@ page trimDirectiveWhitespaces="true" %>
    * 다이렉티브 공백만 제거
#### 스크립트 요소
* 스크립트릿(Scriptlet) : <%...%>
* 표현식(Expression) : <%=...%>
* 선언부(Declaration) : <%!...%> (잘 쓰이지 않는다)
##### 스크립트릿
<%
    자바문법이 그대로 들어간다
%>
*  브라우저에 스크립트릿은 안 보이지만 표현식은 보인다
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
	String[] fruits = {"apple","banana","grape","kiwi"};
	for(int i=0; i<fruits.length;i++){
%>
	<tr>
		<td><%= fruits[i] %></td>
	</tr>	
<%		
	}
%>
</table>
</body>
</html>
```
* 개발자 입장에서 스크립트릿, 표현식을 사용하면 편하지만 같이 일하는 디자이너 입장에서는 이해가 어려울 수 있다
* 따라서 디자이너를 배려해 스크립트릿, 표현식을 다른방법(EL, Action Tag, JSTL)으로 제거해 JSP를 만들어주어야 한다
* JSP는 디자이너와 개발자와 공유자원 thead synchronized(동기화) 필요
##### 표현식
* <%=...%>
* vs System.out.print
    * 표현식은 지정되 위치에 출력
    * sysout은 콘솔에 출력
    * 둘다 객체 출력시 toString 메서드 호출
##### 선언부
* <%!...%>
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
    //멤버변수, 메서드
	public int multiply(int a, int b){
		int c = a*b;
		return c;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int value1 = 3;
	int value2 = 9;
	
	int multiplyResult = multiply(value1,value2);
%>

<%= value1 %> + <%= value2 %> = <%=multiplyResult %>
</body>
</html>
```
#### JSP 처리 과정
<img src="https://postfiles.pstatic.net/MjAyMjA3MTRfMTA1/MDAxNjU3ODAyNTM1NzI1.dW1VdsIEVTVVkW-SYUWrkRI9rtuVpS7dR77JvPk2OuYg.I26Ci5hP8W7z7twmFBt3EmmtYtrdl5t0znAt_V14lBkg.PNG.forget980/image.png?type=w580" width="60%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
* jsp 변경시 다시 컴파일 여부는 100% 보장해주지 않는다
* 다시 컴파일이 안되면 Servlet class 파일을 없애고 JSP파일이 처음 요청 전으로 상태로 만들어준다 
##### JSP 오류가 발생한 경우
* JSP 파일에서 확인이 어려우면 Servlet 파일을 확인
> %workspace%\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost 
* Servlet 클래스를 확인 할 수 있는 경로 이다
* eclipse가 관리하는 경로
* 실제 생성되는 경로는 톰켓 폴더에 work\Catalina\localhost
* 개발자의 컴푸터에서 개발된 프로그램을 실제로 실행 시킬 서버 컴퓨터에 옮겨야 한다
* A-was에서 개발시 다른 컴퓨터에도 실행되려면 A-was가 깔려있어야 한다
* 배포하는 경우 실행할 컴퓨터에 tomcat work폴더에 자바 파일이 생긴다
#### JSP class 사용
```java
package kr.ac.green;

public class Cat {
	private String name;
	private int age;
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}
}
```
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.Cat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Cat cat = new Cat("로시", 4);
%>
<%= cat %>
</body>
</html>
```
#### requset 기본 객체
* request 기본 책체는 JSP 페이지에서 가장 많이 사용하는 기본 객체
* 서버에 요청을 해야 응답을 받을 수 있다

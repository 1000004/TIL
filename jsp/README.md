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
* ISO-8859-1 vs EUC-KR vs UTF-8
    * 
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
#### 디렉티브
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
 #### 스크립트 요소
 * 표현식
 * 스크립트릿
 * 선언부
 #### 기본 객체
 * request, response, session, application, page

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

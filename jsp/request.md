### request 기본 객체
* request 기본 객체는 JSP 페이지에서 가장 많이 사용되는 기본 객체
* 요청한 정보를 자바 객체처럼 쓸수 있게 만들어진 객체를 request 객체
* 브라우저가 요청한 정보를 자바 객체인 request 객체로 표현이 된다
* request 객체는 선언,정의가 필요 없다 → request 기본 객체 type : <<interfave>> HttpSevlectRequset
* was(tomcat 제티 TBOSS web_logic)에게 HttpSevlectRequset을 구현해라 (다형성)
* 사용자는 어떻게 구현했는지와 관계없이 메서드만 호출해서 사용
* java SE는 EE에 포함된다
* HttpSevlectRequset는 SE에 없고 EE에 존재
* request 기본 객체가 제공하는 기능은 다음과 같이 구분
  * 클라이언트(웹 브라우저)와 관련된 정보 읽기 기능
  * 서버와 관련된 정보 읽기 기능
  * **클라이언트가 전송한 요청 파라미터 읽기 기능**
  * 클라이언트가 전송한 요청 헤더 읽기 기능
  * 클라이언트가 전송한 쿠키 읽기 기능
  * **속성 처리 기능**
#### 클라이언트 정보 및 서버 정보 읽기
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글라이언트 및 서버 정보</title>
</head>
<body>
클라이언트IP = <%= request.getRemoteAddr() %><br>
요청정보길이 = <%= request.getContentLength() %><br>
요청정보 인코딩= <%= request.getCharacterEncoding() %><br>
요청저보 컨테츠타입 = <%= request.getContentType() %><br>
요청정보 프로토콜 = <%= request.getProtocol() %><br>
요청정보 전송방식= <%= request.getMethod() %><br>
요청 URI = <%= request.getRequestURI() %><br>
컨텍스트 경로 = <%= request.getContextPath() %><br>
서버이름 = <%= request.getServerName() %><br>
서버포트 = <%= request.getServerPort() %><br>
</body>
</html>
```
* IPv4 주소는 8비트씩 4부분으로 10진수로 표시 주소길이 32비트 
  * 인터넷 사용자수가 급증하면서 IPv4주소가 고갈될 문제 발생
* IPv6 주소는 16비트씩 8부분으로 16진수로 표시더 많은 디바이스 나타낼 수 있는 IPv6
  * 더 많은 디바이스 나타낼 수 있는 IPv6
#### 요청 파라미터 처리(중요)
* HTTML 폼과 요청 파라미터
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>폼 생성</title>
</head>
<body>
<form action="viewParameter.jsp" method="post">
이름 : <input type="text" name="name" size="10"><br>
주소 : <input type="text" name="address" size="30"><br>
좋아하는 동물:
	<input type="checkbox" name="pet" value="dog">강아지
	<input type="checkbox" name="pet" value="cat">고양이
	<input type="checkbox" name="pet" value="pig">돼지
<br>
<input type="submit" value="전송">
</form>
</body>
</html>
```
* from 테그 action 전송위치 method 전송방법
```JSP
<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%
	//파라미터 인코딩으 설정 : request body에만 적용된다
	request.setCharacterEncoding("euc_kr");
%>
<html>
<head>
<title>요청 파라미터 출력</title>
</head>
<body>
<b>request.getParameter() 메서드 사용</b><br>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터= <%= request.getParameter("address") %>
<p>
<b>request.getParameter() 메서드 사용</b><br>
<%
	String[] values = request.getParameterValues("pet");
	if(values != null){
		for(int i = 0; i<values.length;i++){
%>
	<%= values[i] %>
<%
		}
	}
%>
<p>
<b>requestgetParameterNames() 매서드 사용</b><br>
<%
	Enumeration paramEnum = request.getParameterNames();
	while(paramEnum.hasMoreElements()){
		String name = (String)paramEnum.nextElement();
%>
	<%= name %>
<%
	}
%>
<p>
<b>request.getParameterMap() 메서드 사용</b><br>
<%
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("name");
	if(nameParam != null){
%>
name = <%= nameParam[0] %>
<%
	}
%>
</body>
</html>
```
<img src="https://postfiles.pstatic.net/MjAyMjA3MTVfNjYg/MDAxNjU3ODY1MTc4OTI0.gPDHR7TiTQo_SEQ8RRfphsv4MGuXa4GkuBKibBfA0x4g.o-fj1YHWsz_rtEfkrfaCCCTjRtmjihxNyXfzZG4CVDsg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

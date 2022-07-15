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
* 전송을 누르면 viewParameter.jsp를 파라미터 목록을 가지고 실행하도록 요청(name = A address = 서울 pet = dog pet = cat name속성 = value속성)전달
* 사용자가 요청하는 행위 자체 추상화한 것이 request 객체
* request.getParameterMap()
	* Map key는 string value는 String[] (값이 한개가 아닌 것들이 있을 수 있다)
* Enumeration는 Iterator<e>와 유사하다
##### form의 action 속성값 get 방식과 post 방식 차이
* 파라미터를 어디에 담아 전달되는가
* GET : 읽기 -> 서버측 data 변경이 일어나지 않는다.(공개되어도 상관없다)
	* http://localhost:8080/07_15/viewParameter.jsp?name=A&address=B&pet=dog
	* get -> 파라미터 정보-> url에 포함(request line)
	* 읽어 오는 용도
	* 쿼리문자열(Query String) ?가 구분자 URL의 뒤에 입력 데이터를 함께 제공하는 가장 단순한 데이터 전달 방법
	* 파라미터를 지우면 목적으로하는 결과를 볼 수 없다
	* 동일한 작업을 많이 해도 변경이되지 않는다
* POST : 수정, 삭제, 생성 -> 서버측 데이터가 변경이 일어난다.
	* http://localhost:8080/07_15/viewParameter.jsp
	* post -> 파라미터 정보 -> 바디에 포함
	* url로 확인 할 수 없다
	* 수정, 삭제, 생성을 GET할때 사용하면 허용되지 않은 사용자가 허가되지 않은 연산(데이터 변경)이 가능해질 수 있다
	* 보이면 안된는 파라미터 있는 경우 사용 (id, pw) 
* **request.setCharacterEncoding("euc_kr");**
	* 해당 메서드는 파라미터 값을 사용하기 전에 실행해주어야 한다
	* 브라우저가 EU-KR로 보내지 않는다
	* 파라미터 인코딩 설정 - request body에만 적용된다
	* 따라서 post 방식을때만 유효
	* get 방식인 경우 해당 스크립트릿을 추가 해도 글자는 깨진다
	* (page인코딩이 없으면 charset을 따라간다)
* get 인코딩을 보낼때 서유럽 (8859_1)로 전달 다른 인코딩으로 바꾸는 표준이 없다 바꿀 수 있어도 표준방식이 아니다
* GET 방식으로 파라미터 전송 시 인코딩 결정 규칙
	* (표준 인코딩 규칙이 정해져 있지 않기 때문에, 완벽하게 글자 깨지는 현상을 막을 수 없다 상황에 맞춰 사용)
	* <a> 태그의 링크 태그에 쿼리 문자열 추가 : 웹 페이지 인코딩 사요
	* HTTML 폼(FORM)의 method 속성값을 "GET"으로 지정해서 폼을 전송 : 웹 페이지 인코딩 사용
	* 웹 브라우저에 주소에 직접 쿼리 문자열을 포함한 URL 입력 : 웹 브라우저마다 다름
	* HTTP 표준에는 GET 방식으로 전달되는 파라미터 값을 인코딩할 때 어떤 캐릭터셋을 이용해야 한는지에 대한 규칙이 정해져 있지 않다.
	* 표준에 정해진 규틱이 없기 때문에 웹 브라우저마다 처리 방식이 다른 것이다
	* 크롬의 경우 일반적으로 8859_1 인코딩 (영어만 가능 한글지원 안하는 인코딩)
	* 일반적인 브라우저는 request line을 인코딩 할 때 8859_1을 사용
	* 8859_1가 아닌 수 있으므로 브라우저가 인코딩하는 방식을 알아야 한다(브라우저의 버전에 따라 달라지기도 한다)
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Start.jsp</title>
</head>
<body>
	<form action="end.jsp" method="get">
	입력 : <input type="text" name="userInput">
	<input type="submit" />
	</form> 
	<br>
	<a href="end.jsp?userInput=abc">go end<</a>
</body>
</html>
```
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>end.jsp</title>
</head>
<body>
	<%
		if(request.getMethod().equalsIgnoreCase("post")){
			//파라미터에 접근하기전에 호출해야한다.
			request.setCharacterEncoding("euc_kr");
	%>
		userInput : <%= request.getParameter("userInput") %>
	<%
		}else{
			String param = request.getParameter("userInput");
			param = new String(param.getBytes("8859_1"),"euc_kr");
	   		//읽어온 8859_1 인코딩된 param을 param.getBytes method를 이요해 바이트 배열로 바꾸고 다시 euc_kr로 인코딩 한다
	   		//무슨 문자든 바이트값으로 표현이 가능하다
	%>
		get 방식(<%= param %>)
	<%
		}
	%>
</body>
</html>
```
* 톰켓 설정을 변경하면 연결된 web 모두에 영향을 준다
* 톰켓이 필요한 프로그램만 관리
### response 기본 객체
* was가 만들어 준다 추가 메서드 addxx() 변경 메서드 setxx() 존재(직접 만드는것이 아니기 때문에 관리하는 메서드 존재)

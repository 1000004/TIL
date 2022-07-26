### 클라이언트와의 대화2 : 세션
* 서버 세션을 이용하면 클라이언트의 상태를 저장할 수 있다
> session(HttpSession)의 scope는 브라우저로 할당된다  
> 동일한 브라우저에서 만나는 jsp에서의 세션 객체는 동일한 객체이다  
> 세션별로 브라우저 상태를 저장할 수 있다  
* 클라이언트 상태 저장 방싱으로 쿠키를 이용하는 방법과 세션을 이용하는 방법이 있다
* 쿠키와의 차이점은 세션은 웹 브라우저가 아니라 서버에 값을 저장한다
* 쿠키를 이용하면 클라이언트에서 서버에 쿠키로 가지고 있는 정보를 항상 보내주기 때문에 서버측에서 데이터 베이스와 같이 저장 공간에서 해당 클라이언트의 정보를 구해오는 과정이 사라진다
* 쿠키보다 세션 이용하는 것이 나은 이유
  * 브라우저 설정(의존성)으로 쿠키를 이용하는 막을 수 있어 동작이 보장될 수 없다 (쿠키에만 의존하는 경우 쿠키 이용을 막은 브라우저는 이러한 웹 어플리케이션 이용이 불가능)
  * 쿠키를 사용시 request 데이터에 쿠키로 정보를 담아 보내기 때문에 비용(연산 속도)를 고려해야 하며 해킹의 위험이 있다.(취약)
  * (전달 과정에서 요청에 접근해 정보를 빼 갈 수 있다 : 하이재킹)
* 서버는 세션을 사용해서 클라이언트 상태를 유지할 수 있다(사용자의 정보를 담아 두기 알맞음)
#### 세션 사용하기 : session 기본 객체
* 같은 JSP 페이지라도 웹 브라우저에 따라 서로 다른 세션을 사용
* 웹 브라우저마다 세션이 따로 존재하기 때문에, 세션은 웹 브라우저와 관련된 정보를 저장하기에 알맞은 장소
* 쿠키가 클라이언트 측의 데이터 보관소라면 세션은 서버측의 데이터 보관소
* 쿠키와 마찬가지로 세션도 생성을 해야만 정보를 저장
* 일단 세션을 생성하면 session 기본 객체를 통해서 세션을 사용
#### session 기본 객체
* JSP에서 세션을 생성하면 다음과 같이 page 디렉티의 session 속성을 "true"로 지정하면 된다
```jsp
<%@ page session = "true" %>
```
* session 기본 객체가 제공하는 세션 정보 관련 메서드
  * getId() - 세션 고유 ID
  * getCreationTime() - 세션 생성된 시간(session="true"로 되어 있는 어플리케이션 jsp에 최초 접근한 시간)(최초 요청)
  * **getLastAccessedTime()** - 웹 브라우저가 가장 마지막 세션에 접근한 시간(마지막 요청)
    * (jsp 에서 명시적으로 접근하지 않아도 Servlet변환 과정에서 서비스 method로 자동으로 sessuion이 생성되기 때문에 접근했다고 본다)
* 서버측에는 여러 세션이 생기는데 각 세션을 구분하기 위해 세션마다 고유 ID를 할당
* 웹 브라우저는 웹 서버에 연결할 때마다 매번 세션 ID를 보내서 웹 서버가 어떤 세션을 사용할지 판단
* 세션 ID를 공유하기 위해 사용하는 것이 쿠키
* JSESSIONID 쿠키가 세션 ID를 공유할 때 사용하는 쿠키
* sessionInfo.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page session="true"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date time = new Date();
	SimpleDateFormat formatter=
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>세션정보</title>
</head>
<body>
세션ID: <%=session.getId() %><br>
<%
	time.setTime(session.getCreationTime());
%>
세션생성시간: <%= formatter.format(time) %><br>
<%
	time.setTime(session.getLastAccessedTime());
%>
최근접근시간: <%= formatter.format(time) %>
</body>
</html>
```
#### 기본 객체의 속성 사용
* 한법 생성된 세션은 지정한 유효 시간 동안 유지된다
* request 기본 객체가 하나의 요청을 처리하는 데 사용되는 JSP 페이지 사이에서 공유(forward)된다면, session 기본 객체는 웹 브라우저의 영러 요청을 처리하는데 JSP 페이지 사이에서 공유
* 세션에 값을 저장할 때는 속성을 사용
* 브라우저각 유지되는 한 세션의 속성 값은 유지된다
* 쿠키 vs 세션
  * 쿠키 대신에 세션을 사용하는 가장 큰 이유는 세션이 쿠키보다 보안에서 앞선다는 점
  * HTTP 프로토콜을 사용하는 경우 중간에 누군가 쿠키의 값을 읽어올 수 있다(하이제킹)
  * 세션을 사용하는 두 번째 이유는 (흔치 않지만) 웹 브라우저가 쿠키를 지원하지 않을 경우 또는 강제적으로 쿠키를 막는 경우 쿠키는 사용할 수 없게 되지만, 세션은 쿠키 설정 여부에 상관없이 사용 할 수 있다는 점이다.
  * 하지만, 세션은 여러 서버에서 공유할 수 없다 (물리적(서버 컴퓨터)로 분리되어 있지만 논리적으로 합쳐진 서버)
  * 쿠키는 도메인을 이용해서 쿠키를 여러 도메인 주소에 공유 가능(Daum과 같은 포털 사이트는 쿠키를 이용해서 로그인 정보를 저장)
  * 쿠키어 의존성이 높으면 쿠키를 막는 경우 사이트가 동작하지 않을 수 있다.
#### 세션 종료
* 일반적으로 세션을 종료하는 방법으로 (1) 브라우저 종료가 있다
* 임의로 세션을 끊는 방법으로는 (2) session.invlidate()를 사용 할 수 있다
* session.invlidate()을 이용으로 session이 없어지는 아니라 변경된다(존재하지 않는다는 표현x session 속성 사용 불가)
* 세션이 변경되면 기존에 세션이 가지고 있던 속성을 이용 못한다
* 의도적으로 속성 정보를 삭제할때 사용
* (3) timeout은 세션은 마지막 접근 이후 **세션 유효 시간** 이내에 다시 세션에 접근하지 않는 경우 자동으로 세션 종료하는 것을 말한다
```jsp
<%@ page session = "flase" %>
```
* 세션을 쓸 수 없다
```jsp
session.getLastAccessedTime()
```
* xml로 세션 유효시간 설정(분단위)
```xml
<session-config>
  <session-timeout>50</session-timeout> 
</session-config>
```
* jsp 코드로 세션 유효시간 설정(초단위)
```jsp
session.setMaxInactiveInterval(60*60);
```
* session-timeout 태그의 값을 0이나 음수를 설정하면 세션은 유효 시간을 갖지 않는다
* 이경우 명시적으로 session.invaliate() 메서드를 호출하기 전까지 세션 객체각 서버에 유지
* 유효 시간이 없는 상태에서 session.invalidate() 메서드를 실해하지 않으면, 세션 객체가 계속 메모리에 남게 되어 메모리 부족 현상이 발생
* closeSessoin.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>세션 종료</title>
</head>
<body>
세션ID: <%=session.getId() %><br>
<br>
<%= session.getAttribute("test") %>
<hr>
<%
	session.invalidate();
	/*
		더이상 속성에 접근할 수 없다.
		현재페이지 까지는 원래 세션을 유지한다.
		새로운 요청이 발생하면 그때 새로운 세션을 할당한다.
		
		getSession() == getSession(true)
		=> 기존의 세션이 invalidate() 되지 않았다면 기존의 세션을 리턴하고,
		invalidate()된 후라면 새로운 세션을 리턴한다
		
		getSession(false)
		=> getSession 기존의 session이 있으면 가지고 있는 session을 리턴 없으면 null 리턴 (세션이 있을때만 구하겠다)
	*/
	session = request.getSession();
	/*
		* 기존의 session이 있으면 request.getSession()은 가지고 있는 세션을 리턴
		* 지존의 session을 invalidate()한 후 세션에 속성을 추가해야 하는경우에 사용하면 된다.
		* jsp에서는 기본객체라는 개념이 있기 때문에 바로 사용이 가능하지만 Servlet에서
		session 객체를 구할때 request.getSession()을 이용해 얻어야 한다
	*/
%>
세션을 종료하였습니다.
<hr>
세션 ID: <%= session.getId() %>
<br>
<%= session.getServletContext() == application %>
</body>
</html>
</html>
```
* servlet service 메서드로 request와 response 객체는 파라미터로 받기 때문에 구할 필요가 없지만 session은 request.getSession()으로 applcation은 session.getServletContext()로 구해야 한다.
#### 세션을 사용한 로그인 상태 유지
1. 로그인에 성공하면 session 기본 객체의 특정 속성에 데이터를 기록
2. 이후로 session 기본 객체의 특정 속성이 존재하면 로그인할 것으로 간주
3. 로그아웃할 경우 session.invalidate() 메서드를 호출하여 세션을 종료
* sessionLogin.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if(id.equals(password)){
		session.setAttribute("MEMBERID", id);
%>
<html>
<head>
<title>로그인성공</title>
</head>
<body>
로그인에 성공했습니다.
</body>
</html>
<%
```
*sessionLoginForm.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인폼</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/sessionLogin.jsp" 
method="post">
아이디 <input type="text" name="id" size="10">
암호 <input type="password" name="password" size="10">
<input type="submit" value="로그인">
</form>
</body>
</html>
```
* sessionLoginCheck.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	boolean login = memberId == null ? false:true;
%>
<html>
<head><title>로그인여부 검사</title></head>
<body>
<%
	if(login){
%>
아이디 "<%= memberId %>"로 로그인 한 상태
<%
	}else{
%>
로그인하지 않은 상태
<%
	}
%>
```
* sessionLogout.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	boolean login = memberId == null ? false:true;
%>
<html>
<head><title>로그인여부 검사</title></head>
<body>
<%
	if(login){
%>
아이디 "<%= memberId %>"로 로그인 한 상태
<%
	}else{
%>
로그인하지 않은 상태
<%
	}
%>
```

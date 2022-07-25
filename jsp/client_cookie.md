### 클라이언드와의 대화 1 : 쿠키
* 웹서버는 쿠키를 이용해서 웹 브라우저에 정보를 전송할 수 있다.
* 웹 서버로부터 쿠키를 전달받은 웹 브라우저는 이후 웹 서버에 요청을 보낼 때 쿠키를 함꼐 전송
* 이를 사용하면 웹 서버와 웹 브라우저는 필요한 값을 공유하고 상태를 유지할 수 있다.
#### 쿠키 사용하기
* 쿠키는 웹 브라우저가 보관하는 데이터
* 웹 브라우저는 웹 서버에 요청을 보낼 때 쿠키를 함꼐 전송
* 웹 서버는 웹 브라우저가 전송한 쿠키를 사용해서 필요한 테이터를 읽을 수 있다
* 쿠키는 웹 서버와 웹 브라우저 양쪽에서 생성할 수 있는데, JSP에서 생성하는 쿠키는 웹 서버에서 생성하는 쿠키이다.
* 쿠키 동작 방식
  * 1. 쿠키 생성 단계 
    * 웹 서버 측에서 생성 
    * 생성한 쿠키를 응답 데이터의 헤더에 저장해서 웹 브라우저에 전송
  * 2. 쿠키 저장 단계
    * 포함된 쿠키 저장소에 보관
    * 메모리나 파일에 저장
  * 3. 쿠키 전송 단계
    * 웹 브라우저는 저장한 쿠키를 요청이 있을 때마다 웹 서버에 전송(요청 헤더에 쿠키가 담긴다)
    * 웹 서버는 웹 브라우저가 전송한 쿠키를 사용해서 필요한 작업을 수행
* 쿠키의 구성(핵심요소 이름, 값)
  * 이름 (쿠키 이름 하나당 값 하나 (이름: 값), 쿠키는 복수 데이터가 아니다)
    * 콤마, 세미콜론, 공배그 등호기호('=')를 제외한 출력 가능한 아스키 문자로 구성
  * 값
  * 유효시간
  * 도메인
  * 경로
* **하나의 웹 브라우저는 여러 개의 쿠키를 가질 수 있는데, 각 쿠키를 구분할 때 이름을 사용**
* 각 쿠키는 값을 가지며 서버는 이 값을 사용해서 원하는 작업을 수행
* 유효시간을 사용하면 웹 브라우저가 쿠키를 얼마 동안 보관할지를 지정할 수 있다.
* **별도 유효 시간을 지정하지 않으면 웹 브라우저를 종료할 때 쿠키를 함계 삭제**
* 지정한 도메인이나 경로만 쿠키를 전송하도록 제한
#### 쿠키 생성하기
* 처음 플러시 전까지만 헤더 변경이 가능하므로 그전에 쿠키를 응답헤더에 담겨 있어야 한다 (이후에는 헤더에 추가 변경 불가)
* 쿠키의 값은 임의 값이 아닌 서버에서 지정한 값이므로 한글은 피한다
* Cookie 클래스가 제공하는 메서드
  * getName()
  * getValue()
  * setValue(String value)
  * setDomain()
  * setPath(String uri)
  * getPath()
  * setMaxAge(int expiry) - 유효시간을 초 단위로 지정 (음수를 입력할 경우 웹 브라우저를 닫을 때 쿠키가 함꼐 삭제, 유효시간을 지정하지 않으면 음수가 기본값)
  * getMaxAge()
#### 쿠키 값 읽어오기
* Cookie[] cookies = request.getCookies();
* request객체 안에 쿠키가 여러개 일수 있기 때문에 쿠키 배열로 리턴
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Cookie cookie = new Cookie("myName", "myValue");
	response.addCookie(cookie);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>쿠키생성</title>
</head>
<body>

<%= cookie.getName() %> 쿠키의 값 = "<%= cookie.getValue() %>"

</body>
</html>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>쿠키 목록</title>
</head>
<body>
쿠키 목록<br>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length>0){
		for(int i = 0; i < cookies.length;i++){
%>
	<%= cookies[i].getName() %> =
	<%= cookies[i].getValue() %><br>			
<%
		}
	}else{
%>
쿠키가 존재하지 않습니다.
<%
	}
%>
</body>
</html>
```
#### 쿠키 사용하는 예시
* Redirect를 사용하는 경우 url을 노출되기 때문에 일정한 과정을 거쳐 페이지에 도달하는 것이 아닌 url을 통해 페이지에 도달할 가능성이 있다
* 이러한 과정없이 페이지에 도달하는 것을 막기 위해 쿠키를 통해 확인 후 결과 페이지를 보여줄 수 있다
* 쿠키는 사용자가 의도한대로 과정을 거쳐서 왔는지 아니면 안 거치고 왔는지 **클라이언트 상태**를 확인하는 것에 쿠키를 이용
* 메일함을 이용할 때 로그인이 되어 있는지 확인하기 위해 웹 브라우저에 로그인 상태로 쿠키가 심어져 있는지 확인하면 된다
* test.jsp (Redirect시 이동하는 페이지에서 쿠키를 확인한 예시)
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test.jsp</title>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		if(msg == null){
			msg = "wellcome~~!!";
		}
	%>
	<h1><%= msg %></h1>
	<hr>
	<form action="process.jsp" method="post">
		당신의 혈액형은?
		<br>
		<input type="radio" name="bloodType" value="A"/>A
		<input type="radio" name="bloodType" value="B"/>B
		<input type="radio" name="bloodType" value="O"/>O
		<input type="radio" name="bloodType" value="AB"/>AB
		<br>
		<input type="submit"/>
	</form>
</body>
</html>
```
* process.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String bloodType = request.getParameter("bloodType");
	//특정연산한다...
	Cookie c = new Cookie("bloodType", bloodType);
	response.addCookie(c);
	
	response.sendRedirect("result.jsp");
%>
```
* result.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>result.jsp</title>
</head>
<body>
	<h1>테스트 완료~</h1>
	<hr>
	<%
		boolean checked = false;
		Cookie[] arr = request.getCookies();
		if(arr != null){
			for(Cookie temp : arr){
				if(temp.getName().equals("bloodType")){
					out.println("당신의 혈액형 : " + temp.getValue());
					checked = true;
				}
			}
		}
		if(!checked){
		//쿠키가 존재하지 않는 경우 forword로 페이지 이동
	%>
	<jsp:forward page = "test.jsp">
		<jsp:param value="access denied" name="msg"/>
	</jsp:forward>
	<%
		}
	%>
</body>
</html>
```

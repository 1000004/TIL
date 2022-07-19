### response 기본 객체
* was가 만들어 준다 추가 메서드 addxx() 변경 메서드 setxx() 존재(직접 만드는것이 아니기 때문에 관리하는 메서드 존재)
#### 웹 브라우저 캐시 제어를 위한 응답 헤더 입력
* 캐시는 동일한 데이터를 중복해서 로딩하기 않도록 할때 사용
* 페이지를 로드하는데 필요한 이미지, JS, CSS를 다시 로드하지 않고 저장해 놓은 캐시를 불러와 동적인 taxt만 로드하기 때문에 응답속도가 빨라진다
* 하지만 캐시가 과도하게 많아지면 오히려 원하는 캐시를 찾기 위해 시간이 걸리기 때문에 느려질 수 있다
* 게시판 프로그램에서 뒤로가기를 하면 목록을 캐시에서 불러오지만 목록 버튼을 누르면 목록을 다시 로드해 보여준다
* 뒤로가기로 캐시를 불러오게 되면 사용자가 변경된 내용을 확인할 수 없다
##### 웹 브라우저가 응답 결과를 캐시 할 것인지에 대한 여부 설정
  * Cache-Control : HTTP 1.1 버전에서 지원하는 헤더, "no-cache"로 지정 브라우저는 응답 결과를 캐시하지 않는다
	* "no-cahe"로 설정하더라도 응답 내용을 캐시 저장소에 보관
	* 응답 결과가 캐시 저장소 자체에 보과되지 않도록 하려면, "no-store"
  * Pragma : HTTP 1.0 버전에 지원하는 헤더, "no-cache"로 지정하면 웹 브라우저를 응답결과를 캐시에 저장하지 않는다
  * Expires : HTTP 1.0 버전에 지원하는 헤더, 응답 결과의 만료일을 지정 만료일을 현재 시간보다 이전으로 설정함으로써 캐시에 보관되지 않도록 할 수 있다
```JSP
	<%
	 	response.setHeader("Cache-Control", "no-cache");
	   	response.addHeader("Cache-Control", "no-store");
	   	response.setHeader("Pragma", "No-cache");
	   	//1L = 1970년 1월 1일 0.001초
	   	response.setDateHeader("Expires",1L);
	 %>	
```
### 리다이렉트를 이요해서 페이지 이동하기
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp</title>
</head>
<body>
	<h1>a.jsp</h1>
	<%
	   	//리다이렉트 지시
	   	//요청 2번 일어나는게 기술 핵심
	   	//JSP 페이지에서 필요한 코드를 실행(서버측의 상태를 변경하는 코드일 가능성이 높다)
	   	//...(ex 글쓰기 완료)
		response.sendRedirect("b.jsp");
	%>
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
<title>b.jsp</title>
</head>
<body>
	<h1>b.jsp</h1>
</body>
</html>
```
* 리다이렉트는 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능
* 사용자는 이 과정을 모른다 a.jsp를 요청했지만 결과적으로 보게 되는 페이지는 b.jsp 실행 결과
* 요청이 한번더 일어나는데 요청되는 request 객체는 다르다 (request 객체에 파라미터 정보는 없다)
* 사용자의 의도와 상관 없이 서버가 임의의 페이지로 이동
* 요청 2번 일어나는게 기술 핵심
* 특정 페이지를 실행한 후 지정한 페이지로 이동하길 원할 때 리다이렉트 기능을 사용
* 리다이렉트 파라미터는 사용자가 설정하는 것이 아니기 때문에 한글이 아닌 영어를 쓴다
##### 리다이렉트가 필요한 이유
* 페이지에서 글쓰기 완료 한 후 새로고침(이전의 마지막 요청을 한번더 요청)하면 글이 한번더 등록되는 문제 발생
* 글쓰기 완료시 redirct를 통해 글쓰기 완료 페이지를 보여주면 새로고침을 해도 마지막 요청은 글쓰기 완료 페이지를 요청이 되므로 글이 추가로 등록되지 않는다
* post 전송 방식을 써야하는 상황과 유사  → 서버 상태 변경시 사용(두번 일어나는 일을 막는다)
* CRUD R을 제외하고 나머지 작업이 일어나면 redirct해야 한다  
<img src="https://postfiles.pstatic.net/MjAyMjA3MTVfMjEg/MDAxNjU3ODk2MDY1MTMz.0pHXaGXH861PXpcCY5QMkcCAXFwtETv7QwbPh9JQQoYg.2fetIm83TJZ62qsTLi2coL0XPYtnjJL8Nx75eRVCehsg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
### JSP 주석
* &lt;!-- HTML 주석 --&gt;
* <%-- JSP주석 --%>

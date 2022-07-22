### &lt;jsp:forward&gt; 액션 태그를 이용한 JSP 페이지 이동
* &lt;jsp:forward&gt; 액션 태그는 하나의 JSP 페이지에서 다른 JSP 페이지로 요청 처리를 전달할 때 사용
* 리다이렉트와 비교 
  * 단순이 요청 페이지가 아닌 다른 페이지를 보여주기위한 경우 forward가 더 경재적이다
  * forword를 이용하면 request 기본객체를 공유하지만 리다이렉트는 요청이 2번 발생되기 때문에 공유가 안된다
  * 리다리렉트가 일어나면 이후의 코드가 실행이 되지만 forword는 액션 태그를 통해 발생하면 이후의 코드는 실행 되지 않는다(액션 태그인 경우만)
  *  root(/) 개념이가 다르다  
> * #### redirect, form(action), a, script, stype  (html에서 경로를 잡아낼때)  
> http://localhost:8080/  
> request.getContextPath()을 이용 (/[웹경로]를 의미)  
> 다음 태그를 사용할때 사용중인 어플리케이션에서 범위가 한정되는 것이 아니라 다른 어플리케이션(ex https://www.nave.com)으로 이동이 가능하다  
> * #### forward, include  
> http://localhost:8080/[웹경로]  
> 어플리케이션이 한정되어 있다  
> * 같은 위치에 있으면 상대 경로를 이용해도 되지만 폴더 구조가 복잡해지거나 일반적인 경우 절대 경로를 이용하는 것이 좋다  
> * 상대경로를 이용하면 상대 위치나 현재 위치가 바뀌면 경로를 변경 해야 한다
> * 상대경로를 사용하는 경우
>   * 이동할 페이지같은 페이지에 위치한 경우
>   * 이동할 페이지가 현재 폴더의 하위 폴더에 위치한 경우
* 동작한는 윈리가 예외 발생시 에러페이지를 보여주는 원리와 유사
  * &lt;jsp:forward&gt; 액션 태그가 나오기전에 첫 버퍼가 일어나면 실행이 제대로 되지 않는다 (예외 발생이 첫 flash가 발새시 원하는 에러페이지가 제대로 안나온다)
* 단, 에러가 발생해야 에러페이지를 보여주지만 &lt;jsp:forward&gt; 액션 태그는 나오면 의도해서 페이지 이동이 일어난다
* from.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
	<jsp:forword> 액션 태그를 실행하면
	생성했던 출력 결과는 모두 제거된다.
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>from.jsp의 제목</title>
</head>
<body>
이 페이지는 from.jsp가 생성한 것입니다.
<jsp:forward page="/to/to.jsp"/>
</body>
</html>
```
* to.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>to.jsp의 실행 결과</title>
</head>
<body>
이 페이지는 to.jsp가 생성한 것입니다.
</body>
</html>
```
* form.jsp가 아닌 to.jsp가 생성한 응답 결과를 웹 브라우저에 전달한다.
* form.jsp에서 사용한 request, resoonse 기본 객체를 to.jsp에 그대로 전달
* 웹 브라우저의 주소는 from.jsp 그대로이다. 즉, 리다이렉트처럼 to.jsp로 변경되지 않는다
  * 사용자가 지금 무슨 jsp 페이지를 보고 있는지 알 수 없게 할 수 있다
  * forward된 jsp 페이지 정보가 노출 되지 않으며 사용자의 요청으로 서버에서 무슨 일이 일어 났는지 짐작할 수 없게 만들 수 있다
    * 로그인 후 접근가능한 페이지를 임의로 url 노출로 인한 접근을 하지 못하게 한다
  * 요청이 들어오면 요청에 맞게 forward로 페이지에 접근 가능하게 만든다
#### &lt;jsp:forward&gt; 액션 태그를 이용하는 목적
* 간결하고 구조적으로 웹/JSP 프로그래밍을 할 수 있기 때문
* JSP를 분리하여 기능별로 모듈화
  * 기능별로 분리하면 재사용하기 쉽다(**보여주는 것이 아닌 기능적으로 분류**)
  * 모듈화 한 기능들을 관리하는 jsp를 만들어 forword를 통해 원하는 기능들만 이용 가능하다
> <%= "a"+".jsp" %> -> error  
> <% String uri = "a"+".jsp" %>  
> <%= uri %> -> ok  
#### &lt;jsp:forward&gt; 액션 태그의 활용
* &lt;jsp:forward&gt; 액션 태그를 유용하게 사용할 수 있는 경우는 조건에 따라 다른 결과를 보여줘야 할 때
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>옵션 선택 화면</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/veiw.jsp">
	
보고 싶은 페이지 선택:
	<select name="code">
		<option value="A">A페이지</option>
		<option value="B">B페이지</option>
		<option value="C">C페이지</option>
	</select>
<input type="submit" value="이동">
</form>
</body>
</html>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String code = request.getParameter("code");
	String viewPageURI = null;
	
	if(code.equals("A")){
		viewPageURI = "/viewModule/a.jsp";
	}else if(code.equals("B")){
		viewPageURI = "/viewModule/b.jsp";
	}else if(code.equals("C")){
		viewPageURI = "/viewModule/c.jsp";
	}
%>
<jsp:forward page="<%= viewPageURI %>"/>
```
#### &lt;jsp:param&gt; 액션 태그를 이용해서 이동할 페이지에 파라미터 추가하기
* include와 달리 forward은 이동만 하고 되돌아가지 않기 때문에 다시 요청 jsp로 갔을때 파라미터 전송은 생각하지 않아도 된다. 
* 속성을 이용하는 것이 좋다
* &lt;jsp:param&gt; 액션 태그는 String만 전달 가능하며 forward한 jsp에서만 파라미터를 이용 가능(파라미터를 쓸 수 있고 없고 있고가 구분되는 jsp가 생긴다)
* 사용자가 설정하는것이 아닌 코드를 짜는 사람이 임의로 설정한다는 점에서 파라미터의 의미가 퇴색된다
	* 사용자가 입력한 값인지 임의로 설정된 값인지 구분 될 필요가 있다
#### 사용자가 의도하지 않은 의도하지 않은 위치에서 접근을 막는 방법
* forword를 이용해 url을 숨긴다
	* jsp 파일 이름을 정할때 처음에 요청한 파일 이름이 url로 고정되므로 다른 페이지로 forward가 된 사실을 사용자가 알 수 없도록 이점을 고려해야 한다
	* 보고 있는 페이지와 url의 이름이 일치되지 않으면 forward가 일어났음을 유추 될 수 잇다.
* WEB-INF에 jsp 파일을 생성하면 url로는 직접 접근이 불가능하고 검증을 맞치고 forward을 통해서만 접근이 가능
	* WEB-INF 폴더에 의도적으로 jsp를 생성한다 

### 페이지 모듈화와 요청 흐름 제어
* &lt; jsp : 로 시작하는 엑션 태그(action tag)
* &lt;jsp:include&gt; 
#### &lt;jsp:include&gt; 액션 태그를 이용한 공통 영역 작성
* 출력 버퍼를 공유
* &lt;jsp:include&gt; 액션 태그가 나오면 페이지 흐름이 include한 페이지로 넘어가고 해당 페이지가 다 버퍼에 담기면 원래 페이지의 흐름으로 돌아와 이어서 출력 버퍼에 담긴다.
* flush = "true"하면 지정된 JSP page를 실행하기 전에 출력버퍼를 flush를 한다
  * 기본값 "flase"로 설정하는 것이 좋다
* (메소드 호출시 발생하는 흐름과 유사)
* JSP는 분리되어 있다(변환된 Servlet도 따로 생성된다 Servlet을 컴파일하여 class를 만들고 실행하면서 합쳐진다)
* 브라우저에는 응답 데이터로 전송될때 출력버퍼로 합친 상태의 결과물로 전송 된다
* **출력버퍼를 이용하여 물리적으로 불리되어있는 jsp를 논리적으로 이어준다**
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>main</title>
</head>
<body>

main.jap에서 생성한 내용.

<jsp:include page="sub.jsp" flush="false"/>

include 이후의 내용.

</body>
</html>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<p>
sub.jsp에서 생성된 내용.
</p>
```
* include되는 sub.jsp는 main.jsp에 포함되므로 main.jsp에 있는 중복된 태그는 필요없다 (단독으로 사용되지 않는다)
* 여러 JSP 페이지에 공통적으로 나타나는 부분을 jsp 파일로 만들어 include해서 중복을 제거한다
* 다수의 웹 페이지들은 동일한 영역을 갖는다
* 동일한 역역을 include할 파일로 만들고 합치므로써 웹 페이지를 만들 수 있다
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>template.jsp</title>
</head>
<style>
	table{
		margin: 0 auto;
		border-collapse: collapse;
		width: 80%;
	}
	td{
		border : 1px solid black;
	}
	h1{
		text-align: center;
	}
	a {
		text-decoration: none;
	}
	a:hover{
		font-weight: bold;
	}
	#contentsBox{
		text-align: center;
	}
	#menuBox{
		width: 30%
	}
</style>
<body>
	<%
		String contentsName = request.getParameter("contents");
	
		if(contentsName == null){
			contentsName = "a";
		}
		String contentsPage = contentsName + ".jsp";
	%>
	<table>
		<tr>
			<td colspan="2">
				<jsp:include page="logo.jsp"/>
			</td>
		</tr>
		<tr>
			<td id="menuBox">
				<jsp:include page="menu.jsp"/>
			</td>
			<td id="contentsBox">
				<jsp:include page="<%= contentsPage %>"/>
			</td>
		</tr>
	</table>
</body>
</html>
```
> 전체적인 화면에 레이아웃을 가지고 있는 페이지를 template  
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>신나는 자바</h1>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
-Menu-
<ul>
	<li><a href="template.jsp?contents=a">menu A</a></li>
	<li><a href="template.jsp?contents=b">menu B</a></li>
	<li><a href="template.jsp?contents=c">menu C</a></li>
</ul>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h2>contents A</h2>
```
<img src="https://postfiles.pstatic.net/MjAyMjA3MjBfMTEy/MDAxNjU4MzExMjI3ODk0.7zjIvrDYaCqmi2xSJN-GwYnB2_7Y1MkWDSom4NTu4esg.Qh5tiKMndVJw0EpztH1fpbtpo2LnILUTAkE7meAVFLEg.PNG.forget980/image.png?type=w580" width="50%" height="50%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>
* main.jsp가 실행되때 include로 sub.jsp가 실행되고 두 jsp에서 동일한 request 객체를 가진다

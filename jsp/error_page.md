### 에러처리
* try-catch를 이용해 직접 예외 처리 가능
  * (out객체를 활용하면 덜 복잡해진다)
#### 에러 페이지 지정
* 예외 발생시 다른 페이지를 보여준다
* 에러 페이지 따로 만들면 여러 JSP 파일에 공통적으로 적용 가능 
* page 디렉티브로 예외 발생시 보여줄 페이지 설정
* 다른 페이지를 보여주고 있어도 예외가 발생한 페이지로 주소창에 표시
* 사용자는 에러 페이지의 존재를 알 수 없다
```jsp
<%@ page errorPage= "myError.jsp"%>
```
* 에러 발생시 보여줄 페이지 작성시 page 디렉티브에 isErrorPage="true"설정은 필수가 아니다
  * 단, 예외객체를 사용하기 위해서는 필요 
```jsp
<%@ page isErrorPage="true" %>
```
* 인터네 익스플로러는 응답의 상태 코드가 400, 404나 500 등 에러 코드이고, 전체 응답 결과 데이터 길이가 512바이트보다 작을 때 자체적으로 제공하는 오류 메시지 화면을 출력
* 사용자가 어떤 브라우저를 사용할지 모르고 익스플로러 사용도 배제하기 힘들기 때문에 자체적으로 제공하는 페이지를 띄우기 위해 for문을 이용해 바이트를 늘린다
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>
myError.jsp
</h1>
<%= exception %>
</body>
</html>
<%
	//익스플로러를 배제 못하기 때문에 512바이트를 넘기기 위해 추가
	for(int i=0; i<500; i++){
		out.print(" ");
	}
%>
```
#### 에러 페이지 작성하기
#### 버퍼와 에러 페이지의 관계
* 출력 버퍼를 쓰면 처음 버퍼를 플러시하기 전까지 버퍼 내용을 버릴 수 있다
* 플러시 이후(응답 코드 200고정) 예외 발생시 사용에게 예외 발생전 버퍼로 전달된 내용을 보여줬기 때문에 취소를 못한다
* 예외 발생이 예상되는 곳이 버퍼가 첫 플래시 이후라면?
  * 1) 위치 변경
  * 2) 버퍼 크기를 키운다(예외 발생이 예상되는 곳까지)
  * 따라서, 예외 발생 가능성이 있는 파트는 첫 버퍼에 포함되야한다
* 버퍼가 다 차면 버퍼의 내용을 웹 브라우저에 전달하는데, 처음 버퍼를 플러시 할 때 응답 헤더를 전송한다고 배웠다
* 응답 상태 코드는 응답 헤더 앞에 전송되므로 최초로 버퍼를 플러시 하면 응답 상태 코드가 가장 먼저 전송
* 버퍼를 최초로 플러시 할 때까지 에러가 발생하지 않으면 웹 브라우저에 200응답 상태 코드가 전송
* 첫음 버퍼가 flush되고 예외가 발생하면 응답 상태 코드와 일부 응답 결과가 화면이 전송되기 때문에, 일부 페이지의 내용이 웹 브라우저에 출력되고 그 뒤에 에러 페이지의 내용이 붙게 된다
* 버퍼가 플러시 된 이후에 익셉션이 발생하면 에러 페이지가 원하는 형태로 출력되지 않는다
#### 응답 상태 코드별로 에러 페이지 지정하기
* web.xml 파일에 &lt;error-code&gt; 태그 사용한다
* jsp 마다 page 디렉티브로 설정하지 않아도 된다
* 주요 응답 상태 코드
	* 200 : 요청이 정상적으로 처리됨
	* 307 : 임시로 페이지를 리다이렉트함  
	(4xx 클라이언트가 잘못 요청한 경우)
	* 400 : 클라이언트의 요청이 잘못된 구문으로 구성됨
	* 401 : 접근을 허용하지 않음
	* 404 : 요청한 URL을 처리하기 위한 자원이 존재하지 않음
	* 405 : 요청한 메서드(GET,POST,HEAD 등의 전송 방식)을 허용하지 않음  
	(5xx 서버 내부 문제)
	* 500 : 서버 내부 에러가 발생함(예를 들어, JSP에서 익셉션이 발생함)
	* 503 : 서버가 일시적으로 서비스를 제공할 수 없음(급격하게 부하가 물리거나 서버가 임시로 보수 중인 경우가 해당)
```xml
<error-page>
  <error-code>500</error-code>
  <location>/myError.jsp</location>
</error-page>
<error-page>
  <error-code>404</error-code>
  <location>/yourError.jsp</location>
</error-page>
```
#### 익셉션 타입별로 에러 페이지 지정하기
* &lt;error-type&gt; 테그를 이용해 예외 객체의 풀패키지명을 쓴다
```xml
<error-page>
  <exception-type>java.lang.NullPointerException</exception-type>
  <location>/ourError.jsp</location>
</error-page>
```
#### 에러페이지의 우선순위와 에러 페이지 지정 형태
* 우선 순위
	* 1) page 디렉티브
	* 2) web xml - code
	* 3) web xml - 예외타입
	* 아무것도 해당하지 않는 경우 웹 컨테이너가 제공하는 기본 에러 페이지
* 에러 페이지를 설정할때 범위를 줄여가며 설정
	* 에러 코드별로 페이지를 설정하고 
	* 특정 예외에대해 다르게 처리하고자 할때 예외타입별 에러 페이지를 설정하고
	* 개별적으로 jsp에 주곡자하는 예외 페이지는 디렉티브를 이용한다

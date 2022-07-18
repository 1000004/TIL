### application 기본 객체
#### 웹 어플리케이션 초기화 파라미터 읽어오기
* 서블릿 규약은 웹 어플리케이션 전테에  걸쳐서 사용할 수 있는 초기화 파라미터를 정의
* 웹 어플리케이션에서 사용 할 수있는 초기화 파라미터는 WEB-INF\web.xml파일에 <conntext-param>테그를 사용하여 추가
* web.xml파일에는 해당 프로젝트의 설정이 있다
* 프로젝트 전체에 사용할 수 있는 설정값을 web.xml파일에 넣어놓고 불러올 수 있다.
```XML
  <context-param>
  	<description>로깅 여부</description>
  	<param-name>logEnabled</param-name>
  	<param-value>true</param-value>
  </context-param>
  <context-param>
  	<description>디버깅 레벨</description>
  	<param-name>debugLevel</param-name>
  	<param-value>5</param-value>
  </context-param> 
```
```jsp
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>초기화 파라미터 읽어오기</title>
</head>
<body>
초기화 파라미터 목록:
<ul>
<%
	Enumeration<String> initParamEnum = application.getInitParameterNames();
	while (initParamEnum.hasMoreElements()){
		String initParamName = initParamEnum.nextElement();
%>
  <li><%= initParamName %>=
	<%= application.getInitParameter(initParamName) %>
<%
	}
%>
</ul>
</body>
</html>
```

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
* tag description은 생략 가능하다.
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
* 웹 어플리케이션 초기화 파라미터는 테이터베이스 연결과 관련된 설정 파일의 경로나, 로깅 설정 파일, 또는 웹 어플리케이션의 주요 속성 정보를 담과 있는 파일 경로 등을 지정할 때 사용한다.
* 웹 어플리케이션 초기화 파라미터에는 바로 값을 쓰지 않는다 수정시 restart해야 한다
* 저장된 **파일경로**를 값을로 준다
* 경로는 그대로고 그 경로에 있는 파일만 수정하면 된다
* #### &lt;context-param&gt;은 어플리케이션 객체를 가지고 접근한다
* xml 문법 엄격 설정파일이 구조가 정해져 있다
* *가 붙어 있으면 생략가능
#### 서버 정보 읽기
* getServerInfo()
* getMajorVersion()
* getMinorVersion()
* serverlet 버전 기준 [매이전 버전].[마이너버전]
#### 로그 메시지 기록
* 배포시 logs 폴더로 파일로 기록 된다
* jsp가 자체적으로 제공하는 log() 메서드를 사용해도 된다 (중간에 jsp:라는 문장이 추가)
* 로그 메시지를 기록하는 파일은 웹 컨테이너에 따라 다르다
#### 웹 어플리케이션의 자원 구하기
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	char[] buff = new char[128];
	int len = -1;
	
	String filePath = "c:\\test\\notice.txt";
	FileReader fr = null;
	
	try{
		fr = new FileReader(filePath);
		while((len = fr.read(buff)) != -1){
			out.println(new String(buff, 0, len));
		}
	}catch(IOException e){
		e.printStackTrace();
	}finally{
		try{
			fr.close();
		}catch(Exception e){
			
		}
	}
%>
</body>
</html>
```
* 파일을 읽는 jsp(프로그램을)를 만들어두면 들어갈 내용을 작성하는 사람이 간단한 HTML 문법과 정해진 파일위치만 설정해놓으면 jsp파일을 생성해서 웹 페이지로 보이여 줄 수 있다
* 디스크상 경로를 사용하게 되면 개발시 사용된 경로과 운영시 상용된 경로가 달라질 수 있어 내부 경로를 사용한다
* "/"는 root를 표현하는 기호
* &lt;a href="/data.dat"&gt;는 배포시에도 경로가 변경되지 않음
* I/O 읽기/쓰기 시 disk상의 경로를 사용하기 때문에 disk상의 경로을 구하는 메서드 필요
* application 기본 객체가 제공하는 자원 접근 메서드
	* getRealPath(String path)
		* => 어플리케이션 내부 경로 -> 디스크상의 경로
	* getResource(String path)
		* => resourcePath를 읽을 수 있는 InputStream을 리턴
		* => 읽기 밖에 적용할 수 없음
	* getResourceAsStream(String path)
		* => URL 리턴(url.openStream()으로 InputStream을 구할 수 있다)
		* => 읽기 밖에 적용할 수 없음
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<head><title>application 기본 객체 사용하여 자원 읽기</title></head>
</head>
<body>
<%
	String resourcePath = "/message/notice.txt";
%>
자원의 실제 경로:<br>
<%= application.getRealPath(resourcePath)%>
<br>
-------------<br>
<%= resourcePath %>의 내용<br>
-------------<br>
<%
	char[] buff = new char[128];
	int len = -1;
	InputStream is = null;
	InputStreamReader isr = null;
	
	try{
		is = application.getResourceAsStream(resourcePath);
		isr = new InputStreamReader(is);
		while((len = isr.read(buff)) != -1){
			out.println(new String(buff, 0, len));
		}
	}catch(IOException ex){
		out.println("익셉션 발생 : "+ex.getMessage());
	}finally{
		try{
			isr.close();
		}catch(Exception e){}
		try{
			is.close();
		}catch(Exception e){}
}
%>
</body>
</html>	
```
* getResourceAsStream(String path) 사용
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<head><title>application 기본 객체 사용하여 자원일기2</title></head>
</head>
<body>
<%
	String resourcePath = "/message/notice.txt";
	char[] buff = new char[128];
	int len = -1;
	URL url = application.getResource(resourcePath);
	InputStream is = null;
	InputStreamReader isr = null;
	try{
		is = url.openStream();
		isr = new InputStreamReader(is);
		while((len = isr.read(buff)) != -1){
			out.print(new String(buff, 0, len));
		}
	}catch(IOException ex){
		out.println("익셉션 발생: "+ex.getMessage());
	}finally{
		try{
			isr.close();
		}catch(Exception e){}
		try{
			is.close();
		}catch(Exception e){}
	}
%>
</body>
</html>
```
* write.jsp가 list.jsp로 가는 경우 (2)->(3)와 <form>으로 글작성하여 가는 경우(1)->(2)->(3) 2가지
* list.jsp가 하는 일
	(1)글 등록/파일에 쓰기 (2)목록 뽑기/파일 읽기 (3)보여주기
* 2가지 경우를 구분하기 위해 hidden을 이용
* hidden의 value를 확인해고 null이면 쓰기를 수행하고 아니면 수행하지 않는다
* ex &lt;input type="hidden" name="cmd" value=""&gt;
* 하지만 list.jsp에서 (1)글쓰기를 처리하면 새로고침시 직전 작업을 수행하면서 글이 반복적으로 추가된다
* 이를 막기위해 hidden보다는 글쓰기를 하는 jsp파일을 생성하여 response.sendRedirect 메서드를 추가하여 글쓰기가 반복되는 것을 막는다
* xml로 목록 저장경로 설정
```xml
<context-param>
  	<param-name>filePath</param-name>
  	<param-value>/message/data.dat</param-value>
</context-param>
```
* write.jsp
```JSP
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="list.jsp">목록으로</a>
	<form action="doWrite.jsp" method="post">
		한마디 : <input type="text" name="words"/>
		<br>
		작성자 : <input type="text" name="writer"/>
		<br>
		<input type="submit" />
		<input type="hidden" name="cmd" value="">
	</form>
</body>
</html>
```
* doWrite.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.green.*" %>
<%!
	private void closeAll(Closeable...c){
		for(Closeable temp : c){	
			try{
				temp.close();
			}catch(Exception e){}
		}
	}

	private Vector<Doc> readList(String filePath){//읽기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Vector<Doc> docList = null;
		try{
			fis=new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			docList = (Vector<Doc>)ois.readObject();
		}catch(IOException e){
			e.printStackTrace();
			docList = new Vector<Doc>();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			closeAll(ois, fis);
		}
		return docList;
	}
%>
<%		
		//쓰기
		request.setCharacterEncoding("euc_kr");
		String filePath = application.getRealPath(application.getInitParameter("filePath"));
		String words = request.getParameter("words");
		String writer = request.getParameter("writer");
		Doc doc = new Doc(words, writer);
		
		Vector<Doc> docList = readList(filePath);//읽기
		docList.add(doc);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(docList);
			oos.flush();
			oos.reset();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			closeAll(oos, fos);
		}
		response.sendRedirect("list.jsp");
%>
```
* list.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<%!
	private void closeAll(Closeable...c){
		for(Closeable temp : c){	
			try{
				temp.close();
			}catch(Exception e){}
		}
	}

	private Vector<Doc> readList(String filePath){//읽기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Vector<Doc> docList = null;
		try{
			fis=new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			docList = (Vector<Doc>)ois.readObject();
		}catch(IOException e){
			e.printStackTrace();
			docList = new Vector<Doc>();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			closeAll(ois, fis);
		}
		return docList;
	}
%>
<%

	String filePath = application.getRealPath(application.getInitParameter("filePath"));
	
	Vector<Doc> docList = readList(filePath);//읽기
%>
<body>
	<a href="write.jsp">글등록</a>
	<table>
		<caption>글목록</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="4"><%=docList.size() %>개 글 등록됨</th>
			</tr>
		</tfoot>
		<tbody>
			<%
				if(docList.size()==0){
			%>
			<tr>
				<td colspan="4">Empty</td>
			</tr>
			<%
				}else{
					for(int idx=docList.size()-1;idx>=0;idx--){
						Doc temp = docList.get(idx);
			%>
			<tr>
				<td><%= idx + 1 %></td>
				<td><%= temp.getWords() %></td>
				<td><%= temp.getWrider() %></td>
				<td><%= temp.getDate() %></td>
			</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>
</body>
</html>
```

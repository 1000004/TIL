### include 디렉티브를 이용한 중복된 코드 삽입
* include 디렉티브도 &lt;jsp:include&gt; 엑션 태그처럼 지정한 페이지를 현재 위치에 포함시키는 기능을 제공
* 하지만, 포함하는 방식에 차이
  * &lt;jsp:include&gt; 액션 태그는 다른 JSP로 실행 흐름을 이용시켜 실행 결과를 현재 위치에 포함하는 방식
    * servlet 파일이 분리되었다 class를 실행하는 과정에서 합쳐진다(논리적 결합)
    * 독립적으로 동작하지만 보여질때는 결과를 하나로
    * UI구성요소 중복을 소거
    * 메소드 호출 흐름과 유사
  * include 디렉티브는 다른 파일의 내용을 현재 위치에 삽입한 후에 JSP 파일을 자바 파일로 컴파일하는 방식
    * 하나의 Servlet(java) 파일로 합쳐진다(물리적 결합)
    * 복사/붙여넣기하는 방식과 유사
#### include 디렉티브의 처리 방식과 사용법
* <%@ include file="포함할파일" %>
* include 디렉티브를 통해 다른 JSP에 포함되는 JSP 파일의 경우 일반 JSP 파일과 국분하기 위해 확장자로 jspf를 사용
  * jspf : JSP + Fragment JSP 소스 코드 조각
* 동일한 값,연산을 여러 jsp에 쓰면 값과 연산을 가진 jspf파일로 만들어 jsp에 inclde하여 사용
* 자바 소스 코드가 생성될때 합쳐지면서 중복된 값와 연산을 소거할 수 있다
* JSP 2.3 규약은 include 디렉티브를 통해서 포함되는 파일이 변경 내역을 어떻게 적용할지에 대한 내용을 정의하고 있지 않다
  * jspf 파일이 변되어도 적용이 보장되지 않는다 정확한 방법은 생성된 자바파일을 삭제해 준다.
#### include 디렉티브의 활용
* include 디렉티브는 코드 차원에서 다른 JSP를 포함하기 때문에 &lt;jsp:include&gt; 엑션 태그와 다른 용도로 사용
* &lt;jsp:include&gt; 엑션 태그 
  * 레이아웃의 한 구성 요소를 모듈화
    * 값이나 연산의 중복이 아닌 눈으로 들어나는 HTML 태그를 따로 때어내 여러곳에 활용
* include 디렉티브
  *  모든 JSP 페이지에서 사용하는 변수 지정
  *  저작권 표시와 같이 모든 페이지에서 중복되는 간단한 문자
  *  즉, 중복되어 사용하는 값, 연산 분리(imprt를 모아놓기도 한다)
  *  저작권 문장을 포함하는데 활용 가능
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>include 디렉티브</title>
</head>
<body>
<%
	int number = 10;
%>
<%@ include file = "/includee.jspf" %>
공통변수 DATAFOLDER = "<%= dataFolder %>"

</body>
</html>
```
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
includer.jsp에서 저장한 번호: <%= number %>
<p>
<%
	String dataFolder = "c:\\data";
%>
```
#### 코드 조각 자동 포함 가능
* HTML 태그가 존재해야 하는 범위 밖에 존재하면 좋지 않기 때문에 안쓰는 것을 추천한다
* 자동 포함 기능을 여러개 넣을 수 있다 코드를 쓴 순서가 우선 적용된다
*  &lt;jsp:jsp-property-group&gt; 테그를 쓰는 곳이 많아지면 어디서 선언, 정의, 사용됬는지 추적하기 어렵다(변수가 많은경우)
*  include 위치를 마은대로 지정할 수 없다(처음과 끝으로 동일)
```xml
<jsp-config>
  	<jsp-property-group>
  		<url-pattern>/view/*</url-pattern>
  		<include-prelude>/common/variable.jspf</include-prelude>
  		<include-coda>/common/footer.jspf</include-coda>
  	</jsp-property-group>
  </jsp-config>
```
* /view/의 의미는 view 밑에 있는 모든 파일에 적용
* include-prelude tag는 JSP 파일의 앞에 삽입할 jspf 파일 설정
* include-coda tag JSP 파일의 뒤에 삽입할 jspf 파일 설정
* include 디렉트브를 안써도 자동으로 추가된다
* /view/autoInclud.jsp
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>자동 Include 실행</title>
</head>
<body>
현재 시간은 <%= CURRENT_TIME %> 입니다.
</body>
</html>
```
* /common/variable.jspf
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- start -->
<%
	java.util.Date CURRENT_TIME = new java.util.Date();
%>
```
* /common/footer.jspf
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- start -->
<%
	java.util.Date CURRENT_TIME = new java.util.Date();
%>
```
#### &lt;jsp:include&gt; 액션 태그와 태그와 include 디렉티브의 비교
* &lt;jsp:include&gt; 액션 태그와 Include 디렉티브의 차이
	*  &lt;jsp:include&gt; 액션 태그 ↔ include 디렉티브
	*  처리시간(포함 되는 시기) : 요청시간에 처리 ↔ 현재 파일에 삽입시킴
	*  기능(어떤 방식으로) : 별도의 파일로 요청 처리 흐름을 이동(class가 따로 실행 제어권이 넘어가면서 include 메서드와 유사)
	*  ↔ 현재 파일에 삽입시킴(한개의 Servlet 생성)
	*  데이터 전달 방법 : **reqest 기본 객체나 &lt;jsp:param&gt;을 이용한 파라미터 전달**
	*  ↔ 페이지 내의 변수를 선언한 후, 변수에 값 저장
	*  용도 : 화면의 레이아웃의 일부분을 모듈화할 때 주로 사용(중복되는 HTML 코드 제거)
	*  ↔ 다수의 JSP 페이지에서 공통으로 사용되는 변수를 지정하는 코드나 저작권과 같은 문장을 포함(값,연산 중복시 사용)
* **&lt;jsp:include&gt; 액션 태그에서 데이터를 전달 방법은 &lt;jsp:param&gt;을 이용한 파라미터 전달과 reqest 기본 객체를 이용한 attribute 전달 방법이 있다**
	* &lt;jsp:param&gt;을 이용하는 방법보다는 reqest 기본 객체의 attribute을 이용하는 방법을 쓰는 것이 좋다
	* 파라미터는 일반적으로 사용자가 입력하는 것으로 수정 삭제가 불가능한다(get만 할 수 있다 값이 보존된다)
	* 또한 include한 페이지에만 적용되는 파라미터다 태그를 쓴 페이지에서는 파라미터 추가가 안된다
	* 속성을 이용하면 inclue한 페이지에서 데이터를 가져올 수 있다
	* 속성은 수정,삭제가 가능하다
	* &lt;jsp:param&gt;을 쓰는 경우는 차등성을 부여해야 하는 경우(특정 페이지에서만 쓸 수 있게)
		* 값이 보존되므로 삭제나 수정의 위험이 적다

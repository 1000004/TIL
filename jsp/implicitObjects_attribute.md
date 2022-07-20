### JSP 기본 객체의 속성(Attribute) 사용하기
* [기본객체의 영역](https://github.com/yeRim650/TIL/blob/main/jsp/implicitObjects_scope.md)을 제대로 알고 속성을 사용
* 내 개의 기본 객체 pageContext, requestion, session, application은 속성을 가진다
* 기본객체 response는 기본객체가 없다
* 속성은 JSP 페이지 사이에서 정보를 주고받거나 공유하기 위한 목적으로 사용
* 속성은 <속성이름, 값>의 형태(Map과 유사)
* 서로 다른 이름을 갖는 속성을 여러 개 포함할 수 있다
#### 속성 처리 메서드
* **setAttribute(String name, Object value)**
  * Object기 때문에 모든 객체가 들어갈 수 있다
* **getAttribute(String name)**
* removeAttribute(String name)
* getAttributeNames()
  * pageContext 기본 객체에서는 제공하지 않는다
* attribute.jsp
```jsp
<body>
	<%
		pageContext.setAttribute("page", "pageValue");
		request.setAttribute("request", "requestValue");
		session.setAttribute("session", "sessionValue");
		application.setAttribute("application", "applicationValue");
	%>
	<%
		Object o1 = pageContext.getAttribute("page");
		Object o2 = request.getAttribute("request");
		Object o3 = session.getAttribute("session");
		Object o4 = application.getAttribute("application");
	%>
	<%= o1 %>,<%= o2 %>,<%= o3 %>,<%= o4 %>
	<br>
	<a href="other.jsp">go other</a>
</body>
```
* other.jsp
```jsp
<body>
  <%
		Object o1 = pageContext.getAttribute("page");
		Object o2 = request.getAttribute("request");
		Object o3 = session.getAttribute("session");
		Object o4 = application.getAttribute("application");
	%>
	<%= o1 %>,<%= o2 %>,<%= o3 %>,<%= o4 %>
</body>
```
* attribute.jsp 실행시 pageValue,requestValue,sessionValue,applicationValue
* a 태그로 other.jsp로 넘어가 실행시  null,null,sessionValue,applicationValue
  * pageContext 속성 는 attribute.jsp안에만 유효하여 null
  * request는 attribute.jsp 페이지 요청이 끝나고 새로운 other.jsp 페이지 요청되어 null
* 새로운 브라우저에서 other.jsp를 실행 null,null,null,applicationValue
  * 다른 브라우저가 실행하여 session null
  * applicationValue는 모든 클라이언트(브라우저)에서 공유
#### 속성의 값 타입
* setAttribute 메서드의 파라미터가 object이기 때문에 모든 객체를 속성 값으로 설정 할 수 있다
* getAttribute를 사용시 object를 리턴하기 때문에 원래 타입으로 돌리기 위해 형변환이 필요하다
* 기본 데이터 타입의 값은 레퍼 타입을 대신 사용해야 하지만 자바는 기본 데이터 타입과 래퍼 타입 간의 변환을 자동으로 처리해주는 오토 박싱/오토 언박싱(auto boxing/auton nuboxing) 기능을 제공하므로 
  * request.setAttribute("age",20);//바로 int로 파라미터 기입
  * int age = (integer)request.getAttribut("age");//integer를 반환하면 형변환도 필요 없지만 object로 반환하므로 형변환 필요
#### 속성의 활용
* pageContext : (한 번의 요청을 처리하는) 하나의 JSP 페이지 내에서 공유할 값을 저장 한다 . 주로 커스텀 태그에서 새로운 변수를 추가할 때 사용한다 
* request : 한 번의 요청을 처리하는 데 사용되는 모든 JSP 페이지에서 공유할 값을 저장한다. 주로 하나의 요청을 처리하는 데 사용하는 JSP 페이지 사이에서 정보를 전달하기 위해 사용된다.
* session : 한 사용자와 관련된 정보를 JSP 사이에 공유하기 위해 사용한다. 사용자의 로그인 정보와 같은 것들을 저장한다 
  * HTML (state-less)문서 정의만 (값을 저장하지 못한다)
  * 다른 HTML 문서로 넘어갈때 상태값이 유지가 안되므로 로그인 상태를 유지하는 상태값이 웹상에서 존재하도록 프로그램을 만들기 위해 웹프로그래밍이 만들어지고 기본객체의 속성이라는 개념이 생성되었다
* application : 모든 사용자를 위해 공유할 정보를 저장한다. 임시 폴더 경로와 같이 웹어플리케이션의 설정 정보를 주로 저장한다 . 
  * 특정 기능 특정 사용자 특정 클라이언트 만을 위한 값이 application에 들어가면 안된다
* 속성을 저장하기 위해 가장 많이 사용되는 기본 객체는 request 기본 객체와 session 기본 객체
* **MVC**페턴에 기반해서 웹 어플리케이션을 개발시 request 기본 객체의 속성이 주로 사용
* session 기본 객체의 속성은 로그인, 로그아웃과 같이 사용자의 인증정보를 저장할 때 사용
#### parameter ↔ attribute
* String:String ↔ String:object
* 실제 사용자가 결정(의도) ↔ 코드상에서 결정
* 홰손방지 (읽기만) ↔ 변경하고 지울 수 있다 (가공을 한다)
* URL+parmeter는 어플리케이션 상에서 뭘해야하는 결정(요청) ↔ 
* 값을 가공을 위해 필요한 중요한 수단 (사용자 요청이 들어오면 여러 나누어진 단계를 넘가는 정보를 처리하는데 필요)
* attribute는 MVC구조를 구현하기 위해 요청이 들어올때 계층을 나누어 처리해준다

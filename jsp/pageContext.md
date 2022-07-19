### pageContext 기본 객체
* **기본 객체 구하기**
  * JSP에서는 기본 객체를 구할 필요 없지만 Servlet을 바로 작성 할때 필요
  * 단, pageContext 기본 객체 보다 request 기본 개체에서 주로 구한다
* **속성 처리하기**(request에도 있었다)
* 페이지의 흐름 제어하기(기능이 있지만 다른 방법을 쓴다)
* 에러 데이터 구하기(기능이 있지만 다른 방법을 쓴다)
* pageContext 기분 객체를 직접 사용하는 경우는 드물다.
#### pageContext가 제공하는 기본 객체 접근 메서드
* **getRequest()** 리턴타입 ServletRequest
  * HttpServletRequest가 ServletRequest를 상속 받는다
* **getResponse()** 리턴 타입 ServletResponse
  * HttpServletResponse가 ServletResponse를 상속 받는다
* getSession()
* **getServletContext()** 리턴 타입 ServletContext (**application** 기본 객체를 구한다)
* getOut()
* getException()
* getPage()
```JSP
<%
HttpServletRequest httpRequest = 
  (HttpServletRequest)pageContext.getRequest();
%>
request 기본 객체와 pageContext.getRequest()의 동일여부:

<%= request == httpRequest %>
```
* pageContext.getRequest()로 리턴한 ServletRequest를 HttpServletRequest로 **강제 형변환**하면 기존 request와 주소가 같으므로 request == httpRequest는 true가 된다
* (주소 비교시 형변환이 필요 없다)

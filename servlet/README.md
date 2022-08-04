### Servlet
* MVC 구조에서 Controller를 servlet으로 만든다.
* (서블릿 변경시 리스타트)
* 서블릿을 생성하면 xml에 등록이 된다
```xml
<servlet>
    <description></description>
    <display-name>FirstServlet</display-name>
    <servlet-name>FirstServlet</servlet-name>
    <servlet-class>kr.ac.green.FirstServlet</servlet-class>
    <init-param>
      <description></description>
      <param-name>myKey</param-name>
      <param-value>MyValue</param-value>
    </init-param>
    <load-on-startup>0</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>FirstServlet</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
```
*  **url-pattern tag에서 *.do는 웹어플리케이션에서 do로 끝나는 경우 servlet-name tag로 지정한 서블릿으로 보내겠다.**
*  url에 do가 끝에 붙는 경우 무조건 FirstServlet로 감으로써 do 앞에는 무엇이든 명시가 가능하다 따라서 웹 어플리케이션 구조 예측이 어려워 원치않는 접근을 막을 수 있다.
*  기존에는 <%= request.getContextPath() %>/some/other...로 복잡하게 url을 표시했다면 url-pattern tag를 이용하여 go.do로 do만 붙이면 서블릿으로 이동 가능하다.
*  do 앞에 의미를 담을 수 있다 (할일을 구별 가능)
* servlet tag에서 init-param tag에 있는 name과 value는 해당 servlet에서만  사용 가능(getIntiParameter("myKey")) jsp에서 사용 불가
```xml
<!-- application으로 접근 : 모든 jsp에서 활용가능 -->
  <context-param>
  	<param-name>yourKey</param-name>
  	<param-value>yourValue</param-value>
  </context-param>
```
#### 서블릿 method
* init : 최초 1번 실행 (서블릿 객체 생성)
* service : 요청이 들어오면 할일 (get방식으로 요청이 들어오면 doGet method를 호출)(post방식으로 요청이 들어오면 doPost method를 호출)
* destroy : 메모리에서 서블릿 객체 소멸시 실행
* init과 destroy method는 오버라이드할 수 있다.
```java
@Override
	public void init(ServletConfig config) throws ServletException {
    	ServletContext application = config.getServletContext();
    	AnimalDAO.init(application);
	}
```
* init은 첫번째 요청이 있어야 호출이 되지만 비용이 많이드는 동작인 경우 servlet tag 안에 load-on-startup tag를 명시
* load-on-startup tag를 명시하면 서버 실행할때  미리 서블릿 (객체)를 만든다 초기화작업을 사용자 요청전에 만든다
* (초기화 작업 순번 표시 낮은 번호순으로 초기화 같은면 서술된 순서)(넣어주는게 이득이 크다)

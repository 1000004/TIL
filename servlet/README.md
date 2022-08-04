### Servlet
* MVC 구조에서 Controller를 servlet으로 만든다.
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
*  url-pattern tag에서 *.do는 웹어플리케이션에서 do로 끝나는 경우 servlet-name tag로 지정한 서블릿으로 보내겠다.
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

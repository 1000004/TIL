### WAS의 이해
* 서블릿과 서블릿 컨테이너의 서블릿 컨테이너와 같이 웹 기술을 기반으로 동작되는 어플리케이션 서버를 **WAS(Web Application Server)**
* Java에서 말하는 WAS란, Java EE 기술 사양을 준수하여 만든 서버 Java EE 구현체(Implemention)
* Java EE 기술 중에서 서블릿, JSP 등 웹 관련 부분만 구현한 서버 **아파치 재단의 톰캣**
* **서블릿이나 JSP 프로그래밍을 할 때는 사용하는 제품의 버전을 맞추어 API를 사용**
* 사용하는 WAS가 어떤 버전의 JavaEE구현체인지 또는 서블릿 컨테이너인지 확인
* %중요% JavaEE 와 Servlet/JSP 버전, 그리고 구현체 버전
* CGI(웹서버와 웹 애플리케이션 사이에는 데이터를 주고받기 위해 규칙)
* 보통 웹 어플리캐이션을 CGI 프로그램
* 특히 자바로 만든 웹 어플리케이션을 서브릿 
* (서블릿 명칭은 Server와 Applet의 합성어, 클라이언트에게 서비스를 제공하는 작은 단위의 서버 프로그램)
* Java EE : Servlet이라는 규칙 외에 JSP를 만들고 실행하는 규칙, EJB라는 분산 컴포넌트에 관한 규칙, 웹 서비스에 관한 규칙등 기업용 애플리케이션에 제작에 필요한 기술들의 사양을 정의 한것
* Java EE 사양에 따라 개발된 서버를 Java EE 구현체 또는 **WAS** 
* (상용 제품 JEUS WebLogic WebSphere JBossEnterprise 오픈 소스 Geronimo, GlassFish, JBoss Community)
* Java EE 사양 중에서 Servlet과 JSP 기술만 구현한 서버를 '서블릿 컨테이너'
* (Tomcat, Resion, Jetty)
* 서블릿 컨테이너는 서블릿 생성과 실행, 소멸 등 생명주기를 관리

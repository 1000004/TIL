### 웹프로젝트 폴더 구조
* src : 자바 소스 파일을 두는 폴더 서블릿 클래스나 필터, 리스너 등 필요한 모든 자바 클래스 파일 두는 곳
* build/classes : 컴파일된 자바 클래스 파일이 놓이는 폴더 패키지에 소속된 클래스인 경우 이 폴더에 해당 패키지가 자동 생성
* WebContent : HTML, CSS, JavaScript, JSP, 이미지 파일 등 웹 콘텐츠를 두는 폴더 웹 애플리케이션을 서버에 배치할 때 이 폴더의 내용물이 그대로 복사
* WebContent/WEB-INF : 웹 애플리케이션의 설정과 관련된 파일을 두는 폴더 이 폴더에 있는 파일은 클라이언트에서 요청할 수 없다.
* WebContent/WEB-INF/web.xml : 웹 어플리케이션 배치 설명서(Deployment Descriptor) 파일
* WebContent/WEB-INF/lib : 자바 아카이브(Archive) 파일(.jar)을 두는 폴더 
* (아카이브란? '기록보관소' 여러개의 자바 클래스 파일과, 클래스들이 이용하는 관련 리소스(텍스트, 그림 등) 및 메타데이터를 하나의 파일로 모아서 자바 플랫폼에 응용 소프트웨어나 라이브러리를 배포하기 위한 소프트웨어 패키지 파일 포맷)
* 서블릿 클래스는 반드시 **javax.servlet.Servlet** 인터페이스를 구현
* 서블릿 생명주기 메서드 init() service() destroy()
* getServletCofig()는 서블릿 설정 정보를 다루는 ServletConfig 객체를 반환
* getServletInfo()는 서블릿을 작성한 사람에 대한 정보라든가 서블릿 버전, 권리 등을 담은 문자열을 변환
> **서블릿 인스턴스는 하나만 생성되어 웹 애플리케이션이 종료될 때까지 사용된다. 따라서 인스턴스변수가 특정 사용자를 위한 데이터를 보관해서는 안된다. 또한, 클라이언트가 보낸 데이터를 일시적으로 보관하기 위해 서블릿의 인스턴스 변수를 사용해서도 안된다**
* 톰캣 실행 환경의 임시 배치 폴더
* 프로젝트 폴더와 배치 폴더
#### 운영 서버에 배치하기
* 실제 운영하는 서버에 배치할 때는 배치할 파일들을 하나의 웹 아카이브 파일(.war)로 만들어서 배치 폴더에 복사
* 톰캣 홈 폴더에 있는 webapps는 웹 애플리케이션을 배치하는 폴더
* interface Servlet 과 abstract GenericServlet
#### ServletRequest ServletResponse
* ServeltRequest : 클라이언트 요청 정보를 다룰 때 사용(getParameter(), getCharacterEncoding())
* ServletResponse
    * 객체는 응답과 관련된 기능 제공
    * 클라이언트에게 출력하는 데이터의 인코딩 타입 설정, 문자집합을 지정, 출력 데이터를 임시 보관하는 버퍼의 크기 조정
    * 데이터를 출력하기 위해 출력 스트림을 준비할 때 이 객체를 사용
    * setContentType():출력할 데이터의 인코딩 형식과 문자 집합을 지정
    * setCharacterEncoding():출력할 데이터의 문자 집합을 지정 (기본값 ISO-8859-1)
    * setContentType():문자집합
    * getWriter():클라이언트로 출력할 수 있도록 출력 스트림 객체를 반환(이미지나 동영상과 같은 바이너리 데이터를 출력하고 싶을 때는 getOutputSream()사용)
#### **GET 요청으로 넘어온 매개변수 값의 인코딩 설정**
* GET요청은 매개변수 값이 URI에 포함되기 때문에 setCharacterEncoding()으로 문자 집합을 설정할 수 없습니다.
* 서블릿에 권고하는 지침에 따라 URI의 인코딩 형식을 설정
* **Servers/[톰캣실행폴더]/server.xml**
```xml
<Contector connectionTimeout="20000" port="9999"
           protocol="HTTP/1.1" redirectPort="8443"
           URIEncoding="UTF-8">
```
#### @WebServlet 애노테이션을 이용한 서블릿 배치 정보 설정
* Servlet 3.0 사양부터는 애노테이션으로 서블릿 배치 정보 설정

### 웹 어플리케이션 폴더 구성과 URL 매핑
* 완성된 프로그램을 서버 컴퓨터에 옮기면 가능한 과정(배포)
* war 형식으로 배포
* 웹 어플리케이션 폴더는 war 구조
* WEB-INF - web.xml (프로젝트에 대한 설정 파일)
  * <welcome-file>index.jsp</welcome-file> : index.jsp를 만들면 첫 페이지/ 홈페이지 대문이 된다(어플리케이션 root로 들어올때 보여주는 페이지) (없으면 404)
  * 편집 가능 : index.jsp jsp 이름 변경 가능 (변경시 서버를 restart 필요)
  * (index.jsp요청 했지만 redirect시 url은 변경)
  * 이 외에도 설정할 수 있는 정보가 있다
* WEB-INF\classes : 웹 어플리케이션 설정 정보를 담고 있는 web.xml 파일 위치
* WEB-INF\classes : 웹 어플리케이션에서 사용하는 클래스 파일 위치
* WEB-INF\lib : 웹 어플리케이션에서 사용하는 jar파일 위치(어플리케이션에서 사용하는 내부 라이블러리 자동 클래스 path에 잡힌다)
* web.xml 파일을 작성해야 하는 경우
  * 서블릿을 직접 설정하는 경우
  * 리스너(Listener)를 직접 설정하는 경우
  * 특정 URL에 속하는 JSP들에 대해 공통 속성값을 설정하는 경우
* web.xml 파일을 반드시 만들어야 하는 규약은 없어졌지만 거의 대부분 필요하다(web.xml 파일 자동으로 만들어진다)
#### 웹 어플리케이션 폴더와 URL의 관계
* [톰캣]\webapps\[웹경로] → http://host:port[/웹경로]
* webapps\chap02 → http://localhost:808/chap02
* /chap02를 컨텍스트 경로(context path)
* 배포과정
  * 프로잭트 import - WAR file 생성(원하는 위치 생성 / 자바파일도 포함시킬지 결정 포함시키지 않으면 클래스파일만 존재/ 기존게 있으면 덮어쓸것인지 결정)
  * WAR file을 서버 컴퓨터의 톰캣 webapps에 옮긴다
  * 톰켓 startup을 실행시키면 webapps 경로에 웹 어플리케이션 폴더가 생긴다
  * 배포되면 war 형태로 관리

### JDBC Driver
* DB에 따른 JDBC Driver 가 있어야 db와 자바 코드와 연결이 가능하다
* JDBC Driver를 사용하기 위해서는 WEB-INF/lib에 넣어야 한다 (외부 라이브러리를 넣는 공간 자동으로 클래스 path안에 잡힌다)
* 개발환경에서 실행만 시키기 위해서는 톰켓 라이블러리에 넣어도 적용이 되지만 배포시 에러
* 또한 war 파일로 배포시 포함되기 위서는 WEB-INF/lib에 넣어야 한다
#### SE VS EE
* SE 관련 클래스(rt.jar)는 따로 클래스 패스에 추가를 해줬지만
* EE 관련 클래스 패스의 경우 apache tomcat에서 자동으로 클래스 패스에 추가하는 라이브러리에 포함되어 있다

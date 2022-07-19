### JSP 기본 객체와 영역
* 웹 어플리케이션은 네 가지 영역(scope)로 구성
  * PAGE 영역(pageContext객체o page객체x)
  * REQUEST 영역 (request객체)
  * SESSION 영역 (session객체)
  * APPLICATION 영역 (application객체)
* request객체가 가장 많이 이용되고 다음으로 session객체가 많이 사용
* respon객체도 존재?
#### PAGE 영역 : jsp마다 pageContext가 바뀐다
#### REQUEST 영역 : 요청부터 응답까지 같은 request 기본 객체를 유지(하나의 request 객체가 여러 JSP에서 공유 될 수 있다)
  * 요청을 처리할때 여러 JSP를 쓸 수 있다 : **include,forward**
#### SESSION 영역 : 클라이언트 별로 하나씩 session 객체를 가진다(브라우저당 서버에 한개)
  * 브라우저가 종료할 때까지 유지된다(time-out또는 머서드에 의한 종료까지 유지)
  * (서버에 클라이언트가 접속하면 thread를 만들어 관리하는 경우 이러한 thread가 session 객체가 될수 있다)
#### APPLICATION 영역 : 모든 클라이언트가 하나의 application 객체를 공유한다 (모든 JSP는 한개의 application 기본 객체를 공유)
  * WAS가 시작될때 생기고 종료 될때 없어진다
* 변수를 사용할때 지역변수로 처리할지 멤버변수로 처리할지 범위를 정확히 알고 결정
* -> 기본객체의 범위를 정확히 알고 속성을 결정하고 사용
* 기본 객체 response는 속성을 가지지 않는다

### 리스너(Listener)
* **'옵저버 패턴'**
  * 특정한 변화를 구(subscribe)하는 객체들을 보관하고 있다가 변화가 발생(발행(publish)이라는 표현)하면 구독 객체들을 실행하는 방식
* 해당 웹 애플리케이션이 시작되거나 종료될 때 특정한 작업을 수행
* HttpSession에 특정한 작업에 대한 감시와 처리
* HttpServltRequest에 특정한 작업에 대한 감시와 처리
* **ServletContextListener**
  * 스프링 프레임워크를 웹 프로젝트에서 미리 로딩하는 작업을 처리할 때 ServletContextListener를 이용
* **세션 관련 리스너**

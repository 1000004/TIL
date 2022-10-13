### Spring 이용하기
* mybatis 활용
  * xml로 SQL분리
* Contoller, DAO, Serivce
  * Contorller는 클라이언트에게 받는 요청을 수행할 로직을 제어(Control)하는 객체
  * @Controller MVC의 컨트롤러를 위한 어노테이션
  * Service는 로직이 있는 부분 DAO를 통해 데이터베이스(DB)에 가서, 데이터를 DTO로 전달 받은 Dto를 처리하여 서비스에 반환
  * @Service 서비스 계층의 객체를 위한 어노테이션
  * DAO는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담하도록 만든 오브젝트
  * @Repository DAO와 같은 객체를 위한 어노테이션
* DTO 검증 @Valid

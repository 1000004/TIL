### Spring 이용하기
* mybatis 활용
   * xml로 SQL분리
* Contoller, DAO, Serivce
   * Contorller는 클라이언트에게 받는 요청을 수행할 로직을 제어(Control)하는 객체
   * @Controller MVC의 컨트롤러를 위한 어노테이션
   * Service는 로직이 있는 부분 DAO를 통해 데이터베이스(DB)에 가서, 데이터를 DTO로 전달 받은 Dto를 처리하여 서비스에 반환하는 객체
   * @Service 서비스 계층의 객체를 위한 어노테이션
   * DAO는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담하도록 만든 객체
   * @Repository DAO와 같은 객체를 위한 어노테이션
* DTO 검증 @Valid
* 페이징,검색
  * PageRequestDTO, PageResponseDTO
* bootstrap을 활용하여 jsp 구성
### Spring Boot
* Thymeleaf 이용
  * 뷰(View) 관련 기술
* JPA 이용
  * SQL문이 아닌 Method를 통해 DB를 조작할 수 있어, 개발자는 객체 모델을 이용하여 비지니스 로직을 구성하는데만 집중
  * JPA를 이용할 때는 테이블과 SQL을 다루는 것이 아니라 데이터에 해당하는 객체를 엔티티 객체라는 것으로 다루고 JSA로 이를 데이터베이스와 연동해서 관리
* Pageable을 활용한 페이징
* ModelMapper 설정
  * 이처럼 ModelMapper 에서는 map(source, destination) 메소드가 호출되면 source 와 destination 의 타입을 분석하여 매칭 전략 및 기타 설정값에 따라 일치하는 속성을 결정
* CURD 작업 처리
* bootstrap 탬플릿으로 화면 구성
* @Valid의 에러 메시지 처리
  * 유효성 확인

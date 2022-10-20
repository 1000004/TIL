#### AJAX와 JSON
**REST 방식**
* URL - 하나는 하나의 자원을 식별할 수 있는 고유한 값 (자원)
* GET/POST/PUT/DELETE - URL에 대한 작업
* @RestController
	* 메소드의 모든 리턴 값이 JSP나 Thymeleaf로 전송되는게 아니라 바로 JSON이나 XML 등으로 처리
* @RequestBody
	* JSON 문자열을 ReplyDTO로 변환하기 위해서 표시
* @PostMappint 
	* conumes 속성은 해당 메소드를 받아서 소비하는 데이터가 어떤 종류인지 명시
	* MediaType.APPLICATION_JSON_VALUE (JSON 타입의 데이터를 처리하는 메소드)
* @Valid 과정에서 문제가 있는 필드들과 메시지를 JSON 문자열로 전송
**JPA**
* JPA에서 엔티티 간의 관계를 한쪽에서만 참조하는 '단방향'방식으로 구현
	* Many ToOne 연관관계 - Reply
	* 

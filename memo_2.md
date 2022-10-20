객체지향 양방향 A가 B의 참조 B가 A의 참조
데이터베이스에 특정한 PK를 다른 테이블에서 FK로 참조해서 사용
JPA는 객체지향을 통해서 관계형 데이터 베이스를 처리하므로 참조를 결정할 때 다양한 방식 존재
단방향/양방향
* 양방향의 경우 양쪽 객체 모두를 변경해 주어야 하기 때문에 구현할 때도 주의해야 하지만 트랜잭션을 신경 써야만 한다
* list.html 목록에 댓글을 표시하기 위해 BoardListReplyCountDTO
* Projecions.bean 한번에 DTO로 처리
* CustomRestAdvice
  *  @ExceptionHandler

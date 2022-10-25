### AJAX와 JSON
### **REST 방식**
* URL - 하나는 하나의 자원을 식별할 수 있는 고유한 값 (자원)
* GET/POST/PUT/DELETE - URL에 대한 작업
* @RestController
	* 메소드의 모든 리턴 값이 JSP나 Thymeleaf로 전송되는게 아니라 바로 JSON이나 XML 등으로 처리
* @RequestBody
	* JSON 문자열을 ReplyDTO로 변환하기 위해서 표시
* @-Mapping 
	* conumes 속성은 해당 메소드를 받아서 소비하는 데이터가 어떤 종류인지 명시
	* MediaType.APPLICATION_JSON_VALUE (JSON 타입의 데이터를 처리하는 메소드)
### **JSON**
* javascript 객체 ← 브릿지 역활 → java 객체
### **JPA**
* JPA에서 엔티티 간의 관계를 한쪽에서만 참조하는 '단방향'방식으로 구현
	* Many To One 연관관계 - Reply
* BoardListReplyCountDTO - 목록에 댓글 수 표시  
### **Ajax**
* **Axios** 
	* 자바스크립트에서 Promise라는 개념을 도입해서 비동기 호출을 동기화된 방식으로 작성할 수 있도록 하는 문법적 장치
		* Promise : 프로미스가 생성된 시점에는 알려지지 않았을 수도 있는 값을 위한 대리자
	* async/await - 동기 처리를 동기화된 코드처럼 작성
		* async는 함수 선언 시에 사용하는데 해당 함수가 비동기 처리를 위한 함수라는 것을 명시하기 위해서 사용
		* await는 async 함수 내에서 비동기 호출하는 부분에 사용
* 비동기 처리 방식
	* Promise 반환
	* then()과 catch()를 활용 
### **스프링 시큐리티**
> 인증 인가
* CustomSecurityConfig
	* filterChain() - 메소드 설정으로 모든 사용자가 모든 경로로 접근 가능?
	* webSecurityCustomizer() - 정적 자원은 스피링 시큐리티 적용 제외
	* @EnableGlobalMethodSecurity의 prePostEnabled 속성은 사전 혹은 권?을 체크할 수 있습니다.
* CustomUserDetailsService
	* loadUserByUsername() - 로그인 처리 과정에서 호출 (UserDetails 인터페이스 타입 반환)
		* UserDetails는 사용자 인증(Authentication)과 관련된 정보들을 저장하는 역할
		* 스프링 시큐리티는 내부적으로 UserDetails 타입의 객체를 이용해 패스워드를 검사하고, 사용자 권한을 확인
* 자동 로그인 - remember-me 쿠키 생성
### 소셜 로그인 처리
* OAuth2 - REST API를 사용한 로그인 구현
* 로그인된 후에 전달되는 정보는 OAuth2User 타입 
* OAuth2User 타입을 처리하는 OAuth2UserService 인터페이스 구현
----------------
* **Thymeleaf** 의 장점
	* 코드자체가 앞서 말한것처럼 html 같은 웹형태이기에 was없이도 그냥 브라우저에서 직접 띄어볼 수 가 있다.
	* jsp 처럼 전용 문법을 사용하지 않고 그냥 html 엘리먼트에 속성으로 값을 넣어 줄 수 있다
* 단점은 JSP 에 비해 속도가 좀 떨어진다
* **@Autowired** 
	* Spring에서 지원하는 어노테이션
	* 찾는 순서
		* 타입 -> 이름 -> @Qualifier -> 실패
* **@Inject**
	* Java에서 지원하는 어노테이션
	* 찾는 순서
		* 타입 -> @Qualifier-> 이름 -> 실패

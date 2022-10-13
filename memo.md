* Log4j2와 @Log4j2
* CRUD
* 로그인
* hikaricp
* junit
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-tx</artifactId>
		    <version>${org.springframework-version}</version>
		</dependency>
```
@GetMpping
@RequestParam
mvc:annotation-driven conversion-service="conversionService"
* dotoDTO 검증하기
* 페이징
* 검색
* Thymeleaf는 JSP와 동일하게 서버에서 결과물을 생성해서 보내는 방식이지만 조금 HTML에 가깝게 작성할 수 있고 다양한 기능들을 가지고 있습니다.
* 빌더 패턴 : 생성과 관련된 디자인 패턴으로, 동일한 프로세스를 거처 다양한 구성의 인스턴스를 만드는 방법
* https://dev-youngjun.tistory.com/197
* https://velog.io/@park2348190/Lombok-Builder%EC%9D%98-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC
* https://devfunny.tistory.com/423
* 디자인 패턴
* 자바스크립트에서 백틱('')을 이용하면 문자열 결합에 '+'를 이용해야 하는 불편함을 줄일 수 있습니다. 대신에 JSP의 EL이 아니라는 것을 표시하기 위해서 '\${}'로 처리해야 한다
* ModelMapper 설정
* 클래스에는 의존성 주입 외에도 @Transactional 어노테이션을 적용
* @Transactional을 적용하면 스프링은 해당 객체를 감싸는 별도의 클래스를 생성해 내는데 간혹 여러번의 데이터베이스 연결이 있을 수도 있으므로 트랜잭션 처리는 기본을 적용해 두는 것이 좋다
* spring boot로 CURD
* @Valid
* UTF-8 필터 처리
```java
package com.test.mybatis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

@WebFilter
@Log4j
public class UTF8Filter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		log.info("Login check filter...");
		HttpServletRequest req = (HttpServletRequest)request;
		
		req.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
	
}
```

package org.green.first;

import org.springframework.stereotype.Controller;
/*
 * bean으로 등록하는 어노테이션
 * 
 * @Component : bean으로 등록하는 이노테이션 (대빵 밑에 이노테이션은 @Component 상속)
 * @Controller : Controller 역할을 수행
 * @Service : Cmd 클래스 역할 수행
 * @Repository : DAO역할  수행
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MyController {
	//URL만 표시 하는 경우 value 없이 바로 기입
	@RequestMapping("/goGoodBye")
	public String goGoodBye() {
		return "goodBye";
	}
	@RequestMapping("redirectTest")
	public String redirectGoodBye() {
		return "redirect:goGoodBye";
	}
}

package org.green.first;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
	@Controller는 해당 클래스가 컨트롤러임을 의미한다.
	-> HandlerMapping이 검색하는 대상이 된다.
 */
@Controller
public class HomeController {
	//루트로 요청이 GET방식으로 들어오는 경우 home()이 실행된다.
	@RequestMapping(value = {"/","/goHello"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, String myParam) {
		request.setAttribute("myAttr", "myValue");
		System.out.println(myParam);
		return "hello";
	}
	@RequestMapping(value = "/goHello", method = RequestMethod.POST)
	public String homePost() {
		return "postHome";//viewName
	}
	// viewName을 url로 처리한다.
	@RequestMapping("paramTest")
	public void testParam(@RequestParam("myParam") int yourParam) {
		System.out.println(yourParam);
	}
	
}

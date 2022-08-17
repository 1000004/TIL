package org.green.second;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/")
	public ModelAndView start(@RequestParam(value="myParam", required=false, defaultValue="3") int param, Model model) {
		//페이징 할 때 초반 페이지 값이 존재하지 않을 수 있다(null)
		//null인 경우 임의의 값 부여 가능
		System.out.println("param : "+param);
		//Model model -> request 속성
		model.addAttribute("attr","value");
		
		//Model(requset 의 attribute) + View(jsp)
		//start는 view이름이 된다
		ModelAndView mav = new ModelAndView("start");
		mav.addObject("attr", "mav:value");
		return mav;
	}
	// MyBean -> myBean
	@RequestMapping(value="/processData", method=RequestMethod.POST)
	public String prrocess(@ModelAttribute("yourBean") MyBean bean) {
		System.out.println(bean);
		return "result";
	}
}

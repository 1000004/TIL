package org.green.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//id=mainController
public class MainController {
	
	@Autowired
	private MyArmy army;
	
	@Autowired
	private Some some2;
	
	@Autowired
	private BallBasket myBasket;
	
	@Autowired
	private BallBasket myBox;
	
	@RequestMapping("/")
	public String root(Model model) {
		model.addAttribute("army", army);
		model.addAttribute("some", some2);
		model.addAttribute("basket", myBasket);
		model.addAttribute("box", myBox);
		return "start";
	}
}

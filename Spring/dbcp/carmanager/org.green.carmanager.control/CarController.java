package org.green.carmanager.control;

import org.green.carmanager.dto.Car;
import org.green.carmanager.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CarController {
	//ICarDAO가 dao일 필요가 없다
	@Autowired
	private CarService service;
	
	@RequestMapping(value={"/","/getAll"})
	public String goMain(Model model) {
		model.addAttribute("list", service.getAll());
		return "main";
	}
	@RequestMapping(value="/insertCar", method=RequestMethod.POST)
	public String addCar(Car car) {
		service.insertCar(car);
		return "redirect:/getAll";
	}
}

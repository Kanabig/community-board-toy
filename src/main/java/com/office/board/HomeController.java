package com.office.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private final String CLASS_NAME = "[HomeController] ";
	
	@GetMapping(value = {"", "/"})
	public String home() {
		System.out.println("==============================================");
		System.out.println(CLASS_NAME.concat("home()"));
		
		return "home";
	}
	
}

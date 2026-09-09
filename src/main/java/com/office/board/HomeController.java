package com.office.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final String CLASS_NAME = "[HomeController] ";
	
	@GetMapping(value = {"", "/", "/admin"})
	public String home() {
		System.out.println("==============================================");
		System.out.println(CLASS_NAME.concat("home()"));
		
		return "home";
	}
	
}

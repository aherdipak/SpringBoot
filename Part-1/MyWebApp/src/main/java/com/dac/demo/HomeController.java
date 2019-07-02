package com.dac.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String homePage() {
		System.out.println("home");
		
		return "home.jsp";
	}
	
}

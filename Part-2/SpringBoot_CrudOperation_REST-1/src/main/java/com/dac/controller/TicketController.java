package com.dac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "home.jsp";
	}

}

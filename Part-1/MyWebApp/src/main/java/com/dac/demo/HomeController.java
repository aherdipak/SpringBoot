package com.dac.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home1")
	public String homePage1() {
		System.out.println("home");
		
		//return "home.jsp";

		return "home";
	}
	
	
	
	@RequestMapping("/home")
	public String homePage(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("name : "+ name);
		session.setAttribute("name", name);
				
		/*
		 * 
		for passing this name to jsp page w have two choices here
		1. req.setAttribute("name", name); - and in jsp we can use getAttribute
		2. session.setAttribute("name", name); - we can use java code on jsp page and get session value or we can use JSTL/EL */
		
		return "home";
	}
	
}

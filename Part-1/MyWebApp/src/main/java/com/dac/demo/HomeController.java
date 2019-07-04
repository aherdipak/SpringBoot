package com.dac.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	//
	// ModelAndView
	//
	/*@RequestMapping("/home2")
	public String homePage2(String name,HttpSession session ) {
		
		System.out.println("name : "+ name);
		session.setAttribute("name", name);
		
		return "home";
	}*/
	
	/*@RequestMapping("/home2")
	public String homePage2(@RequestParam("name")String myName,HttpSession session ) {
		
		System.out.println("name : "+ myName);
		session.setAttribute("name", myName);
		
		return "home";
	}*/
	
	@RequestMapping("/home2")
	public ModelAndView homePage2(@RequestParam("name")String myName) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("home");
		
		return mv;
	}
	
}

package com.dac.app.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dac.app.bean.User;
import com.dac.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService; 
	
	@GetMapping("/getUserPage")
	public ModelAndView getUserPage() {
		ModelAndView model= new ModelAndView("createuser");
		model.addObject("user", new User());
		model.addObject("allProfile", getAllProfile());
		return model;
	}
	
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@Valid User user,BindingResult bindingResult) {
		ModelAndView model= new ModelAndView("createuser");
		
		if(bindingResult.hasErrors()) {
			model.addObject("user", user);
			model.addObject("allProfile", getAllProfile());
			return model;
		}
		userService.addUser(user);
		model= new ModelAndView("userInfo");
		model.addObject("allUsers", userService.getAllUser());
		model.addObject("msg","Form successfully submited...!!!");
		System.out.println("success");
		return model;
	}
	
	
	public List<String> getAllProfile(){
		
		String a[] = new String[] { "A", "B", "C", "D" }; 
		  
        return Arrays.asList(a); 
	}
	
}

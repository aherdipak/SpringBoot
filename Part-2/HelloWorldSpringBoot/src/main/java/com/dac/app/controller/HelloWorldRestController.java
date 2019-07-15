package com.dac.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@GetMapping("/")
	public String hello() {
		return "Hello World..!!";
	}
	
}

package com.dac.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootLoggingApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootLoggingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
		
		logger.error("Message loged at ERROR lavel");
		logger.info("Message loged at INFO lavel");
		logger.warn("Message loged at WARN lavel");
		logger.debug("Message loged at DEBUG lavel");
	}

	@GetMapping("/")
	public String welcome() {
		String name = "dd";
		if(name.length() == 2) {
			throw new RuntimeException("Opps exception is occured");
		}
		return "Hello World..!!";
	}
	
}

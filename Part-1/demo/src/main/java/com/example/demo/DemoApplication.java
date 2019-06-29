package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		Student std1 = ctx.getBean(Student.class);
		std1.show();
//		
//		Student std2 = ctx.getBean(Student.class);
//		std2.show();

		System.out.println("welcome in Boot....!!");
	}
 
} 

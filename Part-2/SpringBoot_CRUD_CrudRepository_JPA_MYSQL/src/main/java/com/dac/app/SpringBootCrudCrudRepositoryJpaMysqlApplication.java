package com.dac.app;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dac.app.bean.People;
import com.dac.app.service.PeopleService;

@SpringBootApplication
public class SpringBootCrudCrudRepositoryJpaMysqlApplication implements CommandLineRunner {

	@Autowired
	private PeopleService peopleService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudCrudRepositoryJpaMysqlApplication.class, args);
		
		System.out.println("Application started.....!");
	}

	@Override
	public void run(String... args) throws Exception {
		//addPerson();
		addPeople();
	}

	private void addPeople() {
		List<People>personList = Arrays.asList(
				new People("vishal", "sali", "v@gmail.com", new Date()),
				new People("chetan", "bhangale", "c@gmail.com",  new Date()),
				new People("anubhav", "khobragade", "a@gmail.com",  new Date()));
		
		List<People> list = peopleService.addPeople(personList);
		
		for (People people : list) {
			System.out.println(people);
		}
		
	}

	private void addPerson() {
		People people = new People("Deepak", "Aher", "abc@gmail.com", new Date());
		People person = peopleService.addPerson(people);
		System.out.println(person);
	}

}

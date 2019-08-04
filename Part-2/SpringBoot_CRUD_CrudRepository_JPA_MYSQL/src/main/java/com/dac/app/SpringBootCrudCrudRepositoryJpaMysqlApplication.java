package com.dac.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.NamedQueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dac.app.bean.People;
import com.dac.app.service.JpaQueryConceptService;
import com.dac.app.service.PeopleService;

@SpringBootApplication
public class SpringBootCrudCrudRepositoryJpaMysqlApplication implements CommandLineRunner {

	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private JpaQueryConceptService jpaQueryConceptService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudCrudRepositoryJpaMysqlApplication.class, args);
		
		System.out.println("Application started.....!");
	}

	@Override
	public void run(String... args) throws Exception {
		//addPerson();
		//addPeople();
		//getPeopleByIds();
		//deletePeopleByIds();
		//updatePeopleEmailById();
		
		
		// Spring Boot Data JPA Query method concept
		//getPeopleByLastName();
		//getPeopleInfoByFistNameAndEmail();
		
		//Using JPA NamedQueries - @NamedQueries 
		//getPeopleInfoByFirstName();
		//getPeopleInfoByFirstNameAndLastName();
		
		
		// @NamedNativeQueries
		
		//getPeopleInfoByFirstName();
		getPeopleInfoByFirstNameAndLastName();
	}

	
	private void getPeopleInfoByFirstNameAndLastName() {
		List<People>personList = jpaQueryConceptService.getPeopleInfoByFirstNameAndLastName("Deepak","Aher");
		personList.forEach(System.out::println);
		
	}

	private void getPeopleInfoByFirstName() {
		List<People>personList = jpaQueryConceptService.getPeopleInfoByFirstName("Deepak");
		personList.forEach(System.out::println);
		
	}

	//-------------------------------------------
	private void getPeopleInfoByFistNameAndEmail() {
		List<People>personList = jpaQueryConceptService.getPeopleInfoByFistNameAndEmail("Deepak","newEmail@gmail.com");
		personList.forEach(System.out::println);
		
	}

	private void getPeopleByLastName() {
		List<People>personList = jpaQueryConceptService.getPeopleByLastName("Aher");
		personList.forEach(System.out::println);
		
	}

	//---------------------------------------
	private void updatePeopleEmailById() {
		 peopleService.updatePeopleEmailById(4,"newEmail123@gmail.com");
		
	}

	private void deletePeopleByIds() {
		List<Integer> ids= new ArrayList<>();
		ids.add(3);
		
		peopleService.deletePeopleByIds(ids);
	}

	private void getPeopleByIds() {
		List<Integer> ids= new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		ids.add(201);
		
		Iterable<People> peopleList = peopleService.getPeopleByIds(ids);
		peopleList.forEach(System.out::println);
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

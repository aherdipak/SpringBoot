package com.dac.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import javax.persistence.NamedQueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;

import com.dac.app.bean.Employee;
import com.dac.app.bean.People;
import com.dac.app.bean.Student;
import com.dac.app.service.JpaQueryConceptService;
import com.dac.app.service.PaginationService;
import com.dac.app.service.PeopleService;
import com.dac.app.service.QueryAnnotationService;

@SpringBootApplication
//@EnableAsync
public class SpringBootCrudCrudRepositoryJpaMysqlApplication implements CommandLineRunner {

	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private JpaQueryConceptService jpaQueryConceptService;
	
	@Autowired
	private QueryAnnotationService queryAnnotationService;
	
	@Autowired
	private PaginationService paginationService;
	
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
		//getPeopleInfoByFirstNameAndLastName();
		
		//@Query annotation
		//addStudent();
		//getStudentInfoByName();
		//getStudentInfoByIdAndFirstName();
		
		// PAGINATION
		//addEmployee();
		//getPaginationDataByLastName();
		
		// Async query results -- @EnableAsync must required
		/*CompletableFuture<Employee> completableFuture = paginationService.findByEmail("a@gmail.com");
		Employee emp =completableFuture.get(20, TimeUnit.SECONDS);
		System.out.println(emp);*/
		
		// @Query with Named Parameters JPQL
		List<Employee> employeeList = paginationService.findByLastNameOrFirstName("Aher","Deepak");
		employeeList.forEach(System.out::println);
	}

	
	@SuppressWarnings("deprecation")
	private void getPaginationDataByLastName() {
		
		List<Employee> employeeList = paginationService.getPaginationDataByLastName("Aher",new PageRequest(0, 4, Direction.ASC, "firstName"));
		employeeList.forEach(System.out::println);
	}

	private void addEmployee() {
			List<Employee> employeeList = Arrays.asList(
					new Employee("vishal", "sali", "v@gmail.com", new Date()),
					new Employee("chetan", "bhangale", "c@gmail.com",  new Date()),
					new Employee("Deepak", "Aher", "c@gmail.com",  new Date()),
					new Employee("AAA", "Aher", "c@gmail.com",  new Date()),
					new Employee("BBB", "Aher", "c@gmail.com",  new Date()),
					new Employee("CCC", "Aher", "c@gmail.com",  new Date()),
					new Employee("anubhav", "khobragade", "a@gmail.com",  new Date()));
			
			List<Employee> list = paginationService.addEmployee(employeeList);
			
			list.forEach(System.out::println);
	}

	//---------------------------
	
	private void getStudentInfoByIdAndFirstName() {
		Student bean = queryAnnotationService.getStudentInfoByIdAndFirstName(5,"vishal");
		System.out.println(bean);
	}

	private void getStudentInfoByName() {
		List<Student> list = queryAnnotationService.getStudentInfoByName("vishal");
		list.forEach(System.out::println);
	}

	private void addStudent() {
		List<Student> studentList = Arrays.asList(
				new Student("vishal", "sali", "v@gmail.com", new Date()),
				new Student("chetan", "bhangale", "c@gmail.com",  new Date()),
				new Student("anubhav", "khobragade", "a@gmail.com",  new Date()));
		
		List<Student> list = queryAnnotationService.addStudent(studentList);
		
		for (Student std : list) {
			System.out.println(std);
		}
		
	}

	//------------------------
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

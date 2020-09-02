package com.dac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

	
	@PostMapping("/employees/post")
	public emp postEmployees(@RequestBody emp ep) {
		System.out.println("Successfully add in DB");
		return ep;
	}
	
	@GetMapping("/employees")
	public List<emp> getAllEmployees() {
		/*
		Employees list = new Employees();
		list.setEmployeeList(new ArrayList<Employees>());

		list.getEmployeeList().add(new Employees(1, "Lokesh Gupta"));
		list.getEmployeeList().add(new Employees(2, "Alex Kolenchiskey"));
		list.getEmployeeList().add(new Employees(3, "David Kameron"));
		
		*/

		List<emp> list = new ArrayList<>();
		
		list.add(new emp(1, "Lokesh Gupta"));
		list.add(new emp(2, "Alex Kolenchiskey"));
		list.add(new emp(3, "David Kameron"));
		
		return list;
	}

}

class emp{
	private Integer id;
	private String name;
	public emp(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
class Employees{
	private Integer id;
	private String name;
	private List<Employees> employeeList;
	public List<Employees> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employees> employeeList) {
		this.employeeList = employeeList;
	}
	public Employees(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}